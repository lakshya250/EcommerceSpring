package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements  ICategoryGateway{
    @Override
    public CategoryDTO getOneProduct(int id) throws IOException {
        return null;
    }
}


