package it.eman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "it.eman")
public class Application {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

	}

}