package org.example.EcommerceSpring.gateway;

import org.example.EcommerceSpring.dto.FakeStoreCartResponseDTO;
import org.example.EcommerceSpring.dto.ProductResponseDTO;
import org.example.EcommerceSpring.gateway.api.FakeStoreCartApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCartGateway implements ICartGateway{
    private final FakeStoreCartApi fakeStoreCartApi;

    public FakeStoreCartGateway(FakeStoreCartApi fakeStoreCartApi){
        this.fakeStoreCartApi = fakeStoreCartApi;
    }

    @Override
    public List<ProductResponseDTO> getCartById(int id) throws IOException {
        FakeStoreCartResponseDTO response = this.fakeStoreCartApi.getCart(id).execute().body();

        if(response == null){
            throw new IOException("Failed to fetch products from FakeStore Api");
        }

        return response.getProducts().stream()
                .map(product -> ProductResponseDTO.builder()
                        .productId(product.getProductId())
                        .quantity(product.getQuantity())
                        .build())
                .toList();

    }
}
