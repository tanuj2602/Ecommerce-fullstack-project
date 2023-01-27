package com.example.cartmicroservice.feign;

import com.example.cartmicroservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ProductService",url = "http://localhost:8090/product")
public interface ProductService {


    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProducts();

    @GetMapping(value = "/getProductById/{productId}")
    public ProductDto findByProductId(@RequestParam(value = "productId") String productId);


}
