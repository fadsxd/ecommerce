package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.dto.PageDto;
import com.proyecto.ecommerce.dto.ProductDto;
import com.proyecto.ecommerce.entity.Category;
import com.proyecto.ecommerce.entity.Product;
import com.proyecto.ecommerce.mapper.ProductMapper;
import com.proyecto.ecommerce.repository.CategoryRepository;
import com.proyecto.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryService categoryService;

  private ProductMapper productMapper;


  // TODO: SAVE
  @Override
  public Product save(ProductDto dto) {

    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);

    return productRepository.save(product);
  }


  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("PRODUCTO NO ENCONTRADO"));
  }

  //TODO: UPDATE
  @Override
  public Product update(UUID id, ProductDto dto) {
    Product productUpdate = productRepository
        .findById(id).orElseThrow(() -> new EntityNotFoundException("PRODUCTO NO ENCONTRADO"));
    productUpdate.setName(dto.getName());
    productUpdate.setDescription(dto.getDescription());
    productUpdate.setPrice(dto.getPrice());
    productUpdate.setStock(dto.getStock());
    productUpdate.setActive(dto.isActive());
    productUpdate.setImageUrl(dto.getImageUrl());
    return productRepository.save(productUpdate);
  }

  @Override
  public Page<Product> getProduct(Pageable pageable) {
   return productRepository.findAll(pageable);
  }

  // TODO: MAPPER fromEntity
  @Override
  public PageDto<Product> getProductFilter(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice,maxPrice,pageable);
    return productMapper.fromEntity(page);
  }

  @Override
  public PageDto<Product> getCategoryId(UUID id,Double minPrice,Double MaxPrice,Pageable pageable) {
    Page<Product> page = productRepository.findByCategory(String.valueOf(id), minPrice, MaxPrice, pageable);
    return productMapper.fromCategory(page);
  }


}
