package com.example.MerchantMicroservice.services;

import com.example.MerchantMicroservice.entity.Merchant;

import java.util.List;

public interface MerchantService {
    public String addMerchant(Merchant merchant);
    public String delMerchant(String merchantId);

    public List<Merchant> findAll();
    public List<Merchant> deleteById(String merchantId);
}
