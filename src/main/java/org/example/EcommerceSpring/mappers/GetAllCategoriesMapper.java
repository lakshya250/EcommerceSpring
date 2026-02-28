package org.example.EcommerceSpring.mappers;

import org.example.EcommerceSpring.dto.CategoryDTO;

import java.util.List;

public class GetAllCategoriesMapper {
    public static List<String> toFakeStoreCategoryDTO(){
        return List.of();
    }

    public static List<CategoryDTO> toCategoryDTO(List<String> dto){
        return dto.stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
