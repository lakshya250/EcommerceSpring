package org.example.EcommerceSpring.controllers;

import org.example.EcommerceSpring.dto.AllProductsOfCategoryDTO;
import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
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

    CategoryController( @Qualifier("categoryService")ICategoryService _categoryService){
        this.categoryService = _categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()) {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else {
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable Long id) throws Exception{

        AllProductsOfCategoryDTO dto = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(dto);

    }
}

