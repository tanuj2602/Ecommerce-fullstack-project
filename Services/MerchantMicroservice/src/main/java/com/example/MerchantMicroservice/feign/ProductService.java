package com.example.MerchantMicroservice.feign;

import com.example.MerchantMicroservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ProductService",url = "http://localhost:8090/product")
public interface ProductService {

    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProducts();

    @GetMapping(value = "/getProductById/{productId}")
    public List<ProductDto> findByProductId(@PathVariable(value = "productId") String productId);


}
