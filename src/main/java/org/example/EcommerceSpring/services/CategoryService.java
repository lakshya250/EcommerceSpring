package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.AllProductsOfCategoryDTO;
import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.dto.ProductDTO;
import org.example.EcommerceSpring.entity.Category;
import org.example.EcommerceSpring.mappers.CategoryMapper;
import org.example.EcommerceSpring.mappers.ProductMapper;
import org.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("categoryService")
public class CategoryService implements ICategoryService {

    private final CategoryRepository repo;

    CategoryService(CategoryRepository repo){
        this.repo = repo;
    }

    @Override
    public List<CategoryDTO> getAllCategories(){
      List<CategoryDTO> dtos = new ArrayList<>();
      for(Category category : repo.findAll()){
          dtos.add(CategoryMapper.toDto(category));
      }
      return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto){
        Category save = repo.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDto((save));
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception{
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name" + name));

        return CategoryMapper.toDto(category);
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category category = repo.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found with id: " + categoryId));

        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOs)
                .build();
    }
}
