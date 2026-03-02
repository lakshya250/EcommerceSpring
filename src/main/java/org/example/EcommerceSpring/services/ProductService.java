package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductDTO;
import org.example.EcommerceSpring.entity.Product;
import org.example.EcommerceSpring.mappers.ProductMapper;
import org.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  IProductService{

    private final ProductRepository repo;

    ProductService(ProductRepository repo){
        this.repo = repo;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
//        return repo.findById(id)
//                .map(ProductMapper::toDto)
//                .orElseThrow(() -> new Exception("Product not found"));

        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));

        return ProductMapper.toDto(product);
    }


    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product saved = repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);
    }
}
