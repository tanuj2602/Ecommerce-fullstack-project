package com.example.OrderMicroservice.controller;

import com.example.OrderMicroservice.dto.OrderDto;
import com.example.OrderMicroservice.dto.ProductDto;
import com.example.OrderMicroservice.entity.Orders;
import com.example.OrderMicroservice.feign.ProductService;
import com.example.OrderMicroservice.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @PostMapping(value = "/insertProductDetailsByMerchant")
    public ResponseEntity<Object> insertProductDetailsByMerchant(@RequestBody OrderDto productDto)
    {
        Orders orders= new Orders();
        BeanUtils.copyProperties(productDto,orders);
        Orders employeeCreated = orderService.addOrder(orders);
        return new ResponseEntity<>( productDto,HttpStatus.OK);
    }

    @PostMapping(value = "/deleteById/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable String orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

    @GetMapping(value = "/getAllOrders")
    public  List<Orders> getAllProducts() {

        return orderService.findAll();
    }


    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getProductById")
    public List<ProductDto> getpro(@RequestParam String productId)
    {
        return productService.findByProductId(productId);
    }
}
