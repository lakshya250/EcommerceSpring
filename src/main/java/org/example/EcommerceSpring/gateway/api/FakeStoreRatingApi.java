package org.example.EcommerceSpring.gateway.api;

import org.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreRatingApi {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeRating(@Path("id") int id) throws IOException;
}
