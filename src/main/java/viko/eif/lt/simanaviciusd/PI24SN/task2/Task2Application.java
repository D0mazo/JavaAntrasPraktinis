package viko.eif.lt.simanaviciusd.PI24SN.task2;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import viko.eif.lt.simanaviciusd.PI24SN.task2.service.SiuntosServiceImpl;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.HtmlTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.PdfTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.TransformationService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.XmlGenerator;

import java.io.File;

/**
 * Pagrindinis aplikacijos paleidimo taškas.
 */
@SpringBootApplication
public class Task2Application {

	/** Web serviso publikavimo adresas. */
	private static final String ENDPOINT_URL =
			"http://localhost:8080/ws/siuntos";

	/**
	 * Paleidžia aplikaciją, publikuoja Web servisą
	 * ir vykdo XSL transformacijas.
	 *
	 * @param args komandinės eilutės argumentai
	 */
	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Task2Application.class, args);

		// Gauti SiuntosServiceImpl iš Spring konteksto (su repozitorija)
		SiuntosServiceImpl siuntosService =
				context.getBean(SiuntosServiceImpl.class);

		// Publikuoti JAX-WS endpoint
		Endpoint.publish(ENDPOINT_URL, siuntosService);
		System.out.println("Web servisas paleistas: " + ENDPOINT_URL);
		System.out.println("WSDL adresas: " + ENDPOINT_URL + "?wsdl");

		// Generuoti XML iš serviso duomenų ir vykdyti transformacijas
		XmlGenerator xmlGenerator = new XmlGenerator();
		TransformationService transformationService = new TransformationService(
				new HtmlTransformer(),
				new PdfTransformer()
		);

		try {
			File xmlFile = new File("generated-data.xml");
			xmlGenerator.generate(siuntosService.gautiVisasSiuntas(), xmlFile);
			transformationService.transformToHtml("output.html", xmlFile);
			transformationService.transformToPdf("output.pdf", xmlFile);
		} catch (Exception e) {
			System.err.println("Transformacijos klaida: " + e.getMessage());
		}
	}
}