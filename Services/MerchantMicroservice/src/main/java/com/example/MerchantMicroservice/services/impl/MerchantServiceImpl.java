package com.example.MerchantMicroservice.services.impl;

import com.example.MerchantMicroservice.entity.Merchant;
import com.example.MerchantMicroservice.repository.mongo.MerchantRepository;
import com.example.MerchantMicroservice.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public String addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
        return "Merchant added successfully";
    }

    @Override
    public String delMerchant(String merchantId){
        merchantRepository.deleteById(merchantId);
        return "Merchant deleted";
    }

    @Override
    public List<Merchant> findAll(){
        return merchantRepository.findAll();
    }

    @Override
    public List<Merchant> deleteById(String merchantId){
        return null;
    }
}
