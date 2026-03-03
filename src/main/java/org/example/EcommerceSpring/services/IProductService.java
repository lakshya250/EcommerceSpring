package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductDTO;
import org.example.EcommerceSpring.dto.ProductWithCategoryDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;
    ProductDTO createProduct(ProductDTO dto) throws Exception;
    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
