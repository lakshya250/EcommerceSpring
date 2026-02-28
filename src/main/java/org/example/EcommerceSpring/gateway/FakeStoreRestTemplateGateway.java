package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    private final RestTemplateBuilder restTemplateBuilder;

    FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
       RestTemplate restTemplate = restTemplateBuilder.build();
       String url = "https://fakestoreapi.com/products/categories";

        ResponseEntity<List<String>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {}
        );
        if(response.getBody() == null){
            throw new IOException("Failed to fetch catgeories from FakeStore API");
        }
        return GetAllCategoriesMapper.toCategoryDTO(response.getBody());
    }
}
