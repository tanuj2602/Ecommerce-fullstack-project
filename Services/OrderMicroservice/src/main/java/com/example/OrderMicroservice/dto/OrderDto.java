package com.example.OrderMicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String orderId;
    private String userId;
    private String productId;
    private int orderQuantity;
    private double orderPrice;
    private String merchantId;
}
