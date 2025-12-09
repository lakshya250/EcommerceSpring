package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.CategoryDTO;
import org.example.EcommerceSpring.dto.ProductResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICartGateway {
    List<ProductResponseDTO> getCartById(int id) throws IOException;
}
