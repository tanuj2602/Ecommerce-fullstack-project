package com.example.MerchantMicroservice.controller;

import com.example.MerchantMicroservice.entity.Merchant;
import com.example.MerchantMicroservice.repository.mongo.MerchantRepository;
import com.example.MerchantMicroservice.services.MerchantService;
import jdk.management.resource.ResourceRequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;
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
}
