package com.example.cartmicroservice.services;

import com.example.cartmicroservice.entity.Cart;

import java.util.List;

public interface CartService {
    public Cart addToCart(Cart cart);
    public String delCart(String cartItemId);

    public List<Cart> findAll();

    public void deleteById(String cartItemId);

    public Cart findByProductIdUserId(String cartItemId,String productId);

    public boolean deleteByUserIdAndProductId(String userId,String productId);


    public List<Cart> findByUserId(String userId);

}
