package com.example.cartmicroservice.controller;

import com.example.cartmicroservice.dto.CartDto;
import com.example.cartmicroservice.dto.ProductDto;
import com.example.cartmicroservice.entity.Cart;
import com.example.cartmicroservice.feign.ProductService;
import com.example.cartmicroservice.repository.mongo.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.cartmicroservice.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository repo;

    @Autowired
    ProductService productService;

    @PostMapping("/addCart")
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }

    @GetMapping("/findCart")
    public List<Cart> getCart(){
        return cartService.findAll();
    }

    @DeleteMapping(value = "/delete/{cartItemId}")
    public String deleteItem(@PathVariable String cartItemId){
        cartService.deleteById(cartItemId);

        return "Product deleted successfully";
    }

    @GetMapping(value = "/getAllProducts")
    public List<ProductDto> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getProductById/{productId}")
    public ProductDto getproduct(@RequestParam String productId)
    {
        return productService.findByProductId(productId);
    }

    @PostMapping(value = "/saveToCart/{userId}/{productId}")
    public void saveOrdersDetails(@PathVariable(value = "userId") String userId,@PathVariable(value = "productId") String productId)
    {

        Cart cart =cartService.findByProductIdUserId(userId,productId);
        if(cart==null)
        {
        ProductDto productDto = productService.findByProductId(productId);
        CartDto cartDto = new CartDto();
        cartDto.setProductId(productId);
        cartDto.setUserId(userId);
        cartDto.setProductName(productDto.getProductName());
        cartDto.setImageUrl(productDto.getImageUrl().get(0));
        cartDto.setPrice(productDto.getProductPrice());
        cartDto.setRating(productDto.getProductRating());
        cartDto.setQuantity(1);
            Cart cart1= new Cart();
            BeanUtils.copyProperties(cartDto,cart1);
            cartService.addToCart(cart1);
        }
        else
        {
            CartDto cartDto = new CartDto();
            cartDto.setCartItemId(cart.getCartItemId());
            cartDto.setProductId(cart.getProductId());
            cartDto.setUserId(cart.getUserId());
            cartDto.setProductName(cart.getProductName());
            cartDto.setImageUrl(cart.getImageUrl());
            cartDto.setPrice(cart.getPrice());
            cartDto.setRating(cart.getRating());
            cartDto.setQuantity(cart.getQuantity()+1);
            Cart cart1= new Cart();
            BeanUtils.copyProperties(cartDto,cart1);
            cartService.addToCart(cart1);

            //System.out.println(cart.getQuantity());
        }


    }
    @GetMapping(value = "/findByProductIdandUserId/{userId}/{productId}")
    public boolean findByProductIdandUserId(@PathVariable(value = "userId") String cartItemId,@PathVariable(value = "productId") String productId)
    {
        return false;
    }

    @GetMapping(value = "/getAllProductsByUserId/{userId}")
    public ResponseEntity<List<Cart>> getproducts(@PathVariable String userId)
    {
        List<Cart> carts= cartService.findByUserId(userId);
        return new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteByUserIdAndProductId/{userId}/{productId}")
    public boolean deleteByUserIdAndProductId(@PathVariable(value = "userId") String userId,@PathVariable(value = "productId") String productId)
    {
        if(cartService.deleteByUserIdAndProductId(userId,productId))
        {
            return true;
        }
        return false;
    }


}
