package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductResponseDTO;
import org.example.EcommerceSpring.gateway.ICartGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class FakeStoreCartService implements  ICartService{
    private final ICartGateway cartGateway;

    public FakeStoreCartService(ICartGateway cartGateway){
        this.cartGateway = cartGateway;
    }

    @Override
    public List<ProductResponseDTO> getCartById(int id) throws IOException {
        return cartGateway.getCartById(id);
    }
}
