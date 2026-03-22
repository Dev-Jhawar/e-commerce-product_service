package com.example.product_service.serviceImpl;

import com.example.product_service.dto.ProductResponse;
import com.example.product_service.exception.ProductNotFoundException;
import com.example.product_service.dto.CreateProductDTO;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepo;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product does not exists."));

        return ProductMapper.toDTO(product);

    }

    @Override
    public ProductResponse createProductDTO(CreateProductDTO product) {
        Product pro = ProductMapper.toEntity(product);
        return ProductMapper.toDTO(repo.save(pro));

    }
}
