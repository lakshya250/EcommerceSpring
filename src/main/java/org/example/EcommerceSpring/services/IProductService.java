package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;
    ProductDTO createProduct(ProductDTO dto);
}
