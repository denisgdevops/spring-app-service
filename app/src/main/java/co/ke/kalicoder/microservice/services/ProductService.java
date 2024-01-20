package co.ke.kalicoder.microservice.services;

import co.ke.kalicoder.microservice.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
