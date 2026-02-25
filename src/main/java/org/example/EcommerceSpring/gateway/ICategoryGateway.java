package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
