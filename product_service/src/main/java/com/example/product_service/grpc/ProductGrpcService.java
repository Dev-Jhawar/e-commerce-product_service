package com.example.product_service.grpc;

import com.example.product_service.grpc.ProductResponse;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepo;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class ProductGrpcService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepo repo;

    @Override
    public void getProductById(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        Product product = repo.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not Found with ID : " + request.getProductId()));

        ProductResponse productResponse = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setPrice(product.getPrice().doubleValue())
                .setDescription(product.getDescription() == null ? "" : product.getDescription())
                .setStock(product.getStock() == null ? 0 : product.getStock())
                .setCategory(product.getCategory() == null ? "" : product.getCategory())
                .build();

        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }
}
