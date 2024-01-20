package co.ke.kalicoder.microservice.dtos;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private String image_url;
    private double price;
}

