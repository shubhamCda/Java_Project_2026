package com.app.ecom.service;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = new Product();
        updateProductFromRequest(product, productRequest);
        Product saveProduct = productRepository.save(product);
        return mapToProductResponse(saveProduct);

    }

    private ProductResponse mapToProductResponse(Product saveProduct) {
        ProductResponse response = new ProductResponse();
        response.setId(saveProduct.getId());
        response.setName(saveProduct.getName());
        response.setPrice(saveProduct.getPrice());
        response.setActive(saveProduct.isActive());
        response.setCategory(saveProduct.getCategory());
        response.setImageUrl(saveProduct.getImageUrl());
        response.setDescription(saveProduct.getDescription());
        response.setStockQuantity(saveProduct.getStockQuantity());
        return response;
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setDescription(productRequest.getDescription());
        product.setStockQuantity(productRequest.getStockQuantity());
    }
}
