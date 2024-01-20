package co.ke.kalicoder.microservice;

import co.ke.kalicoder.microservice.dtos.ProductDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class AppMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Configuration
	static class Config {
		// Other configurations can go here
	}

	@Component
	static class AppRunner implements CommandLineRunner {

		private final RestTemplate restTemplate;

		public AppRunner(RestTemplate restTemplate) {
			this.restTemplate = restTemplate;
		}

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Application started successfully=============================================");
			System.out.println("AppRunner is executing!");
			// Your code to call the getAllProducts service using restTemplate
			String apiUrl = "http://localhost:8086/api/products";
			ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
					apiUrl,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<ProductDTO>>() {
					});

			List<ProductDTO> products = response.getBody();

			// Print or process the products
			if (products != null) {
				for (ProductDTO product : products) {
					System.out.println(" Description " + product.getDescription() + ", Name: " + product.getName());
				}
			} else {
				System.out.println("No products received");
			}

		}
	}
}
