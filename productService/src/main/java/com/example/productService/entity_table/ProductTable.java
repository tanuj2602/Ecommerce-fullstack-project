package com.example.productService.entity_table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = ProductTable.COLLECTION_NAME)
public class ProductTable {

    public static final String COLLECTION_NAME="productDetailstable";

    @Id
    private String productId;
    private String productName;
    private String productDiscription;
    private double productPrice;
    private int productStock;
    private String imageUrl;
    private List<String> merchantId;
    private String productCategory;

}
