package org.example.EcommerceSpring.controllers;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.services.ICategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class CategoryController {

    // Constructor based dependency injection
   //    private ICategoryService categoryService;
   //
   //    CategoryController(ICategoryService _categoryService){
   //        this.categoryService = _categoryService;
   //    }

    // field based dependency injection
    //    @Autowired
    //    private ICategoryService categoryService;

    private final ICategoryService categoryService;

    CategoryController(ICategoryService _categoryService){
        this.categoryService = _categoryService;
    }


    @GetMapping("/{id}")
    public CategoryDTO getOneProduct(@PathVariable int id){
        return this.categoryService.getOneProduct(id);
    }
}

