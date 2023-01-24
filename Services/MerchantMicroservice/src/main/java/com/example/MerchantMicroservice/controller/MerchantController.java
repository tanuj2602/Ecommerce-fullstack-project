package com.example.MerchantMicroservice.controller;

import com.example.MerchantMicroservice.dto.ProductDto;
import com.example.MerchantMicroservice.entity.Merchant;
import com.example.MerchantMicroservice.feign.ProductService;
import com.example.MerchantMicroservice.repository.mongo.MerchantRepository;
import com.example.MerchantMicroservice.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @Autowired
    ProductService productService;
    @Autowired
    private MerchantRepository repo;

    @PostMapping("/addMerchant")
    public String addMerchant(@RequestBody Merchant merchant){
        repo.save(merchant);
        return merchantService.addMerchant(merchant);
    }

    @GetMapping("/findMerchant")
    public List<Merchant> getMerchant(){
        return merchantService.findAll();
    }

    @DeleteMapping(value = "/delete/{merchantId}")
    public String deleteMerchant(@PathVariable String merchantId){
        merchantService.deleteById(merchantId);
        return "Merchant deleted successfully";
    }

    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getProductById")
    public List<ProductDto> getpro(@RequestParam String productId)
    {
        return productService.findByProductId(productId);
    }


}
