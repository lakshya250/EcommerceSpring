package org.example.EcommerceSpring.services;


import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        return null;
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        return null;
    }
}

