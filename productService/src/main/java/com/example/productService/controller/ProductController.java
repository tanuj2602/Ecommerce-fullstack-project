package com.example.productService.controller;

import com.example.productService.dto.ProductDto;
import com.example.productService.entity_table.ProductTable;
import com.example.productService.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping(value = "/insertProductDetailsByMerchant")
    public ResponseEntity<Object> insertProductDetailsByMerchant(@RequestBody ProductDto productDto)
    {
        ProductTable productTable= new ProductTable();
        BeanUtils.copyProperties(productDto,productTable);
        ProductTable employeeCreated = productService.insertProductDetails(productTable);
        return new ResponseEntity<>( productDto,HttpStatus.OK);
    }

    @GetMapping(value = "/searchItemsByName/{name}")
    public  ResponseEntity<List<ProductTable>> getItemsByName(@PathVariable(value = "name") String name) {

             List<ProductTable> productTables=productService.findByName(name);
     return new ResponseEntity<List<ProductTable>>(productTables, HttpStatus.OK);
    }

    @GetMapping(value = "/getProductById/{productId}")
    public ResponseEntity<Optional<ProductTable>> getItemByProductId(@PathVariable(value = "productId") String productId)
    {
        return new ResponseEntity<>(productService.findById(productId),HttpStatus.OK);
    }

    @GetMapping(value = "/searchItemsByCategoryId/{categoryId}")
    public  ResponseEntity<List<ProductTable>> getItemsByCategory(@PathVariable(value = "categoryId") String categoryId) {

        List<ProductTable> productTables=productService.findByCategory(categoryId);
        return new ResponseEntity<List<ProductTable>>(productTables, HttpStatus.OK);
    }

//    @GetMapping(value = "/searchItemsByName/{name}")
//    public  ResponseEntity<List<ProductTable>> getItemsByMerchantId(@PathVariable(value = "merchantId") String merchantId) {
//
//        List<ProductTable> productTables=productService.findByName(merchantId);
//        return new ResponseEntity<List<ProductTable>>(productTables, HttpStatus.OK);
//    }


}
