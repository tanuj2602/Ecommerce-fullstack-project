package com.example.OrderMicroservice.controller;

import com.example.OrderMicroservice.dto.OrderDto;
import com.example.OrderMicroservice.dto.ProductDto;
import com.example.OrderMicroservice.entity.Orders;
import com.example.OrderMicroservice.feign.MailService;
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

    @Autowired
    MailService mailService;

    @PostMapping(value = "/insertProductDetailsByMerchant")
    public ResponseEntity<Object> insertProductDetailsByMerchant(@RequestBody OrderDto productDto)
    {
        Orders orders= new Orders();
        BeanUtils.copyProperties(productDto,orders);
        Orders employeeCreated = orderService.addOrder(orders);
        return new ResponseEntity<>( productDto,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable String orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

    @GetMapping(value = "/getAllOrders")
    public  List<Orders> getAllProducts() {

        return orderService.findAll();
    }

    @PostMapping("/sendMail/{email}")
    public String sendMail(@PathVariable String email)
    {
        String status = mailService.sendSimpleMail(email);

        return status;
    }


    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getProductById/{productId}")
    public ProductDto getpro(@RequestParam String productId)
    {
        return productService.findByProductId(productId);
    }


    @PostMapping(value = "/saveOrders/{userId}/{productId}")
    public boolean saveOrdersDetails(@PathVariable(value = "userId") String userId,@PathVariable(value = "productId") String productId)
    {
        ProductDto productDto = productService.findByProductId(productId);
        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(productId);
        orderDto.setUserId(userId);
        orderDto.setProductName(productDto.getProductName());
        orderDto.setImageUrl(productDto.getImageUrl().get(0));
        orderDto.setOrderPrice(productDto.getProductPrice());
        orderDto.setRating(productDto.getProductRating());
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDto,orders);
        orderService.addOrder(orders);
        return true;
    }

    @GetMapping(value = "/getOrdersByUserId/{userId}")
    public  List<Orders> getOrdersByUserId(@PathVariable ("userId") String userId) {
        return orderService.findByUserId(userId);
    }


    @GetMapping(value = "/UpdateStockByProductId/{productId}")
    public boolean UpdateStockByProductId(@PathVariable(value = "productId") String productId)
    {
        return productService.UpdateStockByProductId(productId);
    }

}
