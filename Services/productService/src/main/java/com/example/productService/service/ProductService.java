package com.example.productService.service;

import com.example.productService.entity_table.ProductTable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public ProductTable insertProductDetails(ProductTable productTable);

    List<ProductTable> findByName(String name);
    public Optional<ProductTable> findByProductId(String productId);
    List<ProductTable> findByCategory(String name);
//    public Optional<ProductTable> findById(String productId);

    public List<ProductTable> findAll();

    public List<ProductTable> findByMercahntId(String merchantId );
    public boolean updateByProductId(String product_Id);
    public boolean UpdateStock(String product_Id, String merchantId,int Stock);
}
