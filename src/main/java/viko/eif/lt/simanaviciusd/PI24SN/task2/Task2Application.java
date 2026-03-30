package viko.eif.lt.simanaviciusd.PI24SN.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.TransformationService;

/**
 * Pagrindinis aplikacijos paleidimo taškas.
 */
@SpringBootApplication
public class Task2Application {

	/**
	 * Paleidžia Spring Boot aplikaciją ir vykdo transformacijas.
	 *
	 * @param args komandinės eilutės argumentai
	 */
	public static void main(String[] args) {
		SpringApplication.run(Task2Application.class, args);

		TransformationService service = new TransformationService();

		try {
			service.transformToHtml("output.html");
			service.transformToPdf("output.pdf");
		} catch (Exception e) {
			System.err.println("Transformacijos klaida: " + e.getMessage());
		}
	}
}