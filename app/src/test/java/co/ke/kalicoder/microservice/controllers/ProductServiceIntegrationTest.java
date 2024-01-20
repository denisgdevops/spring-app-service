//package co.ke.kalicoder.microservice.controllers;
//
//import co.ke.kalicoder.microservice.dtos.ProductDTO;
//import co.ke.kalicoder.microservice.services.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class ProductServiceIntegrationTest {
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    void testGetAllProducts() {
//        List<ProductDTO> products = productService.getAllProducts();
//
//        assertEquals(5, products.size());
//    }
//
//    @Test
//    void testCreateProduct() {
//        ProductDTO product1 = new ProductDTO();
//        product1.setName("Pencil");
//        product1.setDescription("Product Description");
//        product1.setImage_url("Product Image");
//        product1.setPrice(100);
//
//        ProductDTO createdProduct = productService.createProduct(product1);
//
//       // assertNotNull(createdProduct.getId());
//        assertEquals(product1.getName(), createdProduct.getName());
//        assertEquals(product1.getDescription(), createdProduct.getDescription());
//        assertEquals(product1.getPrice(), createdProduct.getPrice());
//    }
//}
