package com.example.productService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private String productId;
    private String productName;
    private String productDiscription;
    private double productPrice;
    private int productStock;
    private String imageUrl;
    private List<String> merchantId;
    private String productCategory;

}
