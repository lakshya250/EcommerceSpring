package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.entity.Category;
import org.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // this annotation is used to enable mockito for the test class with Junit
public class CategoryServiceTest {

    //try to simulate behaviour of repo instead of directly calling the repo
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories(){
        //Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repository to return the categories

        //Act
        List<CategoryDTO> result = categoryService.getAllCategories(); //service is actually called which calls the mocked repo

        //Assert
        assertEquals(result.size(),3);
        verify(categoryRepository,times(1)).findAll();
    }

}
