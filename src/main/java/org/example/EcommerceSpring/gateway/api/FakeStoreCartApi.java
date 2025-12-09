package org.example.EcommerceSpring.gateway.api;

import org.example.EcommerceSpring.dto.FakeStoreCartResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreCartApi {
    @GET("/carts/{id}")
    Call<FakeStoreCartResponseDTO> getCart(@Path("id") int id) throws IOException;
}
