package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import org.example.EcommerceSpring.dto.RatingDTO;
import org.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.example.EcommerceSpring.gateway.api.FakeStoreRatingApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class FakeStoreRatingGateway implements  IRatingGateway{

    private final FakeStoreRatingApi fakeStoreRatingApi;

    FakeStoreRatingGateway(FakeStoreRatingApi fakeStoreRatingApi){
        this.fakeStoreRatingApi = fakeStoreRatingApi;
    }

    @Override
    public RatingDTO getRatingById(int id) throws IOException {
        FakeStoreProductResponseDTO response = this.fakeStoreRatingApi.getFakeRating(id).execute().body();
        if(response == null){
            throw new IOException("Product not found");
        }
        return response.getRating();
    }
}
