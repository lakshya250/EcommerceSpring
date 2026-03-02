package org.example.EcommerceSpring.controllers;

import org.example.EcommerceSpring.dto.RatingDTO;
import org.example.EcommerceSpring.services.IRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@RequestMapping("/api/products/rating")
public class RatingController {

    private final IRatingService ratingService;

    RatingController(IRatingService ratingService){
        this.ratingService = ratingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDTO> getRatingById(@PathVariable int id) throws IOException {
       RatingDTO result = this.ratingService.getRatingById(id);
       return ResponseEntity.ok(result);
    }
}
