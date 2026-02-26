package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.RatingDTO;

import java.io.IOException;

public interface IRatingGateway {
    RatingDTO getRatingById(int id) throws IOException;
}
