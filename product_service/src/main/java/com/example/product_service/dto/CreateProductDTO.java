package com.example.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDTO {

    @NotBlank(message = "Product name is Required.")
    private String name;

    private String description;

    @NotBlank(message = "Price is Required.")
    private BigDecimal price;

    private Integer stock;
    private String category;


}
