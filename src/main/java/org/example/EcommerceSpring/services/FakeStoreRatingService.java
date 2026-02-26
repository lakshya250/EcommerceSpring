package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.RatingDTO;
import org.example.EcommerceSpring.gateway.IRatingGateway;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class FakeStoreRatingService implements IRatingService{

    private final IRatingGateway ratingGateway;

    FakeStoreRatingService(IRatingGateway ratingGateway){
        this.ratingGateway = ratingGateway;
    }

    @Override
    public RatingDTO getRatingById(int id) throws IOException {
        return this.ratingGateway.getRatingById(id);
    }
}
