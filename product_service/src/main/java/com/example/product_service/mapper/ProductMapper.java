package com.example.product_service.mapper;

import com.example.product_service.dto.CreateProductDTO;
import com.example.product_service.dto.ProductResponse;
import com.example.product_service.model.Product;

public class ProductMapper {

    public static ProductResponse toDTO(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .stock(product.getStock())
                .category(product.getCategory())
                .createdAt(product.getCreatedAt())
                .build();
    }

    public static Product toEntity(CreateProductDTO product) {
        return Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .stock(product.getStock())
                .build();
    }

}
