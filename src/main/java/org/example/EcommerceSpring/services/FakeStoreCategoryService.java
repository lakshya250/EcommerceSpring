package org.example.EcommerceSpring.services;


import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    FakeStoreCategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }

    @Override
    public CategoryDTO getOneProduct(int id) {
        try {
            return categoryGateway.getOneProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

