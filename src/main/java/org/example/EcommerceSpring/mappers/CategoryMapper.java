package org.example.EcommerceSpring.mappers;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
         return CategoryDTO.builder()
                 .id(category.getId())
                 .name(category.getName())
                 .build();
    }

    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}
