package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import org.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public CategoryDTO getOneProduct(int id) {

        try {
            FakeStoreCategoryResponseDTO response =
                    fakeStoreCategoryApi.getOneProduct(id).execute().body();

            return CategoryDTO.builder()
                    .id(response.getId())
                    .title(response.getTitle())
                    .price(response.getPrice())
                    .description(response.getDescription())
                    .category(response.getCategory())
                    .image(response.getImage())
                    .rating(response.getRating())
                    .build();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
