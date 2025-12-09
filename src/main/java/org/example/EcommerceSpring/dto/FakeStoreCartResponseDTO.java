package org.example.EcommerceSpring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreCartResponseDTO {
    private Integer id;
    private Integer userId;
    private String date;
    private List<ProductResponseDTO> products;
}
