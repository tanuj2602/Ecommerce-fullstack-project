package com.example.productService.service.impl;

import com.example.productService.entity_table.ProductTable;
import com.example.productService.repository.ProductRepository;
import com.example.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductTable insertProductDetails(ProductTable productTable) {
        return productRepository.save(productTable);
    }

    @Override
    public List<ProductTable> findByName(String name) {
        return productRepository.findByproductName(name);
    }

    @Override
    public List<ProductTable> findByCategory(String categoryId) {
        return productRepository.findByproductCategory(categoryId);
    }

    @Override
    public Optional<ProductTable> findByProductId(String productId) {
        return productRepository.findByproductId(productId);
    }

    @Override
    public List<ProductTable> findAll() {
        List<ProductTable> productTables = new ArrayList<ProductTable>();
        List<ProductTable> productTables1 = productRepository.findAll();

        for(int i=0;i<productTables1.size();i++)
        {
            if(productTables1.get(i).getProductStock()>0)
            {
                productTables.add(productTables1.get(i));
            }
        }
        return productTables;
    }

    @Override
    public List<ProductTable> findByMercahntId(String merchantId) {
        return productRepository.findByMerchantId(merchantId);
    }
    @Override
    public boolean updateByProductId(String product_Id) {
        Optional<ProductTable> productTable = productRepository.findByproductId(product_Id);
        ProductTable productTable1= new ProductTable();

        if(productTable.isPresent()==true)
        {
            productTable1 = productTable.get();
            int Stock=productTable1.getProductStock()-1;
            productTable1.setProductStock(Stock);
            productRepository.save(productTable1);
            return true;
        }

        return false;
    }

    @Override
    public boolean UpdateStock(String product_Id, String merchantId, int Stock) {

        Optional<ProductTable> productTable = productRepository.findByproductId(product_Id);
        if(productTable.isPresent()==true)
        {
            ProductTable productTable1= new ProductTable();
            productTable1 = productTable.get();
            productTable1.setProductStock(Stock);
            productRepository.save(productTable1);
        }

        return productRepository.UpdateStock(product_Id,merchantId,Stock);
    }
}
