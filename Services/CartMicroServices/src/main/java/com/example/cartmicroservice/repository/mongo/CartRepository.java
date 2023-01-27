package com.example.cartmicroservice.repository.mongo;

import com.example.cartmicroservice.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    public Cart findByProductIdAndUserId(String productId, String userId);
    public List<Cart> findByUserId(String userId);
    public void deleteByCartItemId(String cartItemId);
    public void deleteByUserIdAndProductId(String userId,String productId);
    }
