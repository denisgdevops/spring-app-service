package co.ke.kalicoder.microservice;

import co.ke.kalicoder.microservice.controllers.ProductController;
import co.ke.kalicoder.microservice.dtos.ProductDTO;
import co.ke.kalicoder.microservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.util.List;

@SpringBootTest
class AppMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	private MockMvc mockMvc;

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	void getAllProducts() throws Exception {
		ProductDTO product1 = new ProductDTO();
		product1.setName("Pencil");
		product1.setDescription("Product Description");
		product1.setImage_url("Product Image");
		product1.setPrice(100);

		ProductDTO product2 = new ProductDTO();
		product2.setName("Rubber");
		product2.setDescription("Rubber Description");
		product2.setImage_url("Rubber Image");
		product2.setPrice(200);


		List<ProductDTO> products = Arrays.asList(product1, product2);

		when(productService.getAllProducts()).thenReturn(products);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(products.size()))
				.andDo(print());
	}





}
