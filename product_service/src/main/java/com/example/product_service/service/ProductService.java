package com.example.product_service.service;

import com.example.product_service.dto.ProductResponse;
import com.example.product_service.dto.CreateProductDTO;

public interface ProductService {

    ProductResponse createProductDTO(CreateProductDTO product);

    ProductResponse getProductById(Long id);

}
