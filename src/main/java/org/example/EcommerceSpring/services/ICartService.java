package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICartService {
    List<ProductResponseDTO> getCartById(int id) throws IOException;
}
