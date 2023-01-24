package com.example.OrderMicroservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Orders.COLLECTION_NAME)
public class Orders {
    public static final String COLLECTION_NAME="Orders";
    @Id
    private String orderId;
    private String userId;
    private String productId;
    private int orderQuantity;
    private double orderPrice;
    private String merchantId;
}
