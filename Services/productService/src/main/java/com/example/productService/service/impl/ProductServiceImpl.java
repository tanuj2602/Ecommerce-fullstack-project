package com.example.productService.service.impl;

import com.example.productService.entity_table.ProductTable;
import com.example.productService.repository.ProductRepository;
import com.example.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductTable insertProductDetails(ProductTable productTable) {
        return productRepository.save(productTable);
    }

    @Override
    public List<ProductTable> findByName(String name) {
        return productRepository.findByproductName(name);
    }

    @Override
    public List<ProductTable> findByCategory(String categoryId) {
        return productRepository.findByproductCategory(categoryId);
    }

    @Override
    public Optional<ProductTable> findById(String productId) {
        return productRepository.findById(productId);
    }
}
