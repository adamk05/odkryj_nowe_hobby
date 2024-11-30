package chlopaki.z.frontu.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Głowna klasa Spring Boot
 */
@SpringBootApplication
public class HobbyApplication {

	/**
	 * Domyślny konstruktor
	 */
	public HobbyApplication() {}

	/**
	 * Metoda uruchamiająca aplikację Spring Boot
	 * @param args domyślne argumenty
	 */
	public static void main(String[] args) {
		SpringApplication.run(HobbyApplication.class, args);
	}

}
