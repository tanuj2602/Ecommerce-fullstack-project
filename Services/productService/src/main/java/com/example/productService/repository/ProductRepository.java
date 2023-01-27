package com.example.productService.repository;

import com.example.productService.entity_table.ProductTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductTable,Integer> ,ProductCustomRepository{

    public List<ProductTable> findByproductName(String productName);
    public Optional<ProductTable> findByproductId(String productName);
    public List<ProductTable> findByproductCategory(String categoryId);
    public List<ProductTable> findByMerchantId(String merchantId );
    public boolean UpdateStock(String product_Id, String merchantId,int Stock);
}
