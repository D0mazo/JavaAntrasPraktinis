package viko.eif.lt.simanaviciusd.PI24SN.task2;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import viko.eif.lt.simanaviciusd.PI24SN.task2.service.SiuntosServiceImpl;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.HtmlTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.PdfTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.TransformationService;
import java.io.File;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.XmlGenerator;

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
		SpringApplication.run(Task2Application.class, args);

		// Publikuoti JAX-WS endpoint
		Endpoint.publish(ENDPOINT_URL, new SiuntosServiceImpl());
		System.out.println("Web servisas paleistas: " + ENDPOINT_URL);
		System.out.println("WSDL adresas: " + ENDPOINT_URL + "?wsdl");

		// servisas
		SiuntosServiceImpl siuntosService = new SiuntosServiceImpl();
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