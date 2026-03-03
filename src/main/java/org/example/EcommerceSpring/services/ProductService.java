package org.example.EcommerceSpring.services;

import org.example.EcommerceSpring.dto.ProductDTO;
import org.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import org.example.EcommerceSpring.entity.Category;
import org.example.EcommerceSpring.entity.Product;
import org.example.EcommerceSpring.mappers.ProductMapper;
import org.example.EcommerceSpring.repository.CategoryRepository;
import org.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  IProductService{

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    ProductService(ProductRepository repo,CategoryRepository categoryRepository){
        this.repo = repo;
        this.categoryRepository = categoryRepository;
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
    public ProductDTO createProduct(ProductDTO dto) throws  Exception{
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        Product saved = repo.save(ProductMapper.toEntity(dto,category));
        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));

        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
