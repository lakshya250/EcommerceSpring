package org.example.EcommerceSpring.controllers;

import org.example.EcommerceSpring.dto.ProductDTO;
import org.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import org.example.EcommerceSpring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) throws Exception{
            ProductDTO result = this.productService.getProductById(id);
            return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception{
        ProductWithCategoryDTO dto = productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }
}
