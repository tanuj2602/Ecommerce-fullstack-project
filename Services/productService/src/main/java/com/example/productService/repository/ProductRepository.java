package com.example.productService.repository;

import com.example.productService.entity_table.ProductTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductTable,Integer> {

    public List<ProductTable> findByproductName(String productName);
    public List<ProductTable> findByproductId(String productName);
    public List<ProductTable> findByproductCategory(String categoryId);
    public List<ProductTable> findByMerchantId(String merchantId );
}
