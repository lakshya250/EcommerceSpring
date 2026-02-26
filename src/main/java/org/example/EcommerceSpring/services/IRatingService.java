package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.RatingDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface IRatingService {
    RatingDTO getRatingById(int id) throws IOException;
}
