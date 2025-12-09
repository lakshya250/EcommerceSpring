package org.example.EcommerceSpring.controllers;

import org.example.EcommerceSpring.dto.ProductResponseDTO;
import org.example.EcommerceSpring.services.ICartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final ICartService cartService;

    public CartController(ICartService cartService){
        this.cartService = cartService;
    }


    @GetMapping("/{id}")
    public List<ProductResponseDTO> getCartById(@PathVariable int id) throws IOException {
        return cartService.getCartById(id);
    }
}
