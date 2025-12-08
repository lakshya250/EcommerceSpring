package org.example.EcommerceSpring.gateway.api;

import org.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreCategoryApi {

    @GET("/products/{id}")
    Call<FakeStoreCategoryResponseDTO> getOneProduct(@Path("id") int id);
}
