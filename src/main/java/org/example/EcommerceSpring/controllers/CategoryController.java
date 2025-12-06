package org.example.EcommerceSpring.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public String getCategory(){
        return "Electronics";
    }

    @GetMapping("/count")
    public int getCount() {  // if we call a GET req on /api/categories/count
        return 5;
    }
}
