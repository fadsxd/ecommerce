package com.proyecto.ecommerce.mapper;

import com.proyecto.ecommerce.dto.PageDto;
import com.proyecto.ecommerce.dto.ProductDto;
import com.proyecto.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  //TODO : SAVE
  public PageDto<Product> fromEntity (Page<Product> page){
    PageDto<Product> pageDto = new PageDto<>();
    pageDto.setContent(page.getContent());
    pageDto.setPageNumber(page.getNumber());
    pageDto.setPageSize(page.getSize());
    pageDto.setTotalPages(page.getTotalPages());
    pageDto.setTotalElements(page.getTotalElements());
    return pageDto;
  }

  //TODO :
  public Product fromDto (ProductDto dto){
    Product product = new Product();
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());
    product.setActive(dto.isActive());
    product.setImageUrl(dto.getImageUrl());
    return product;
  }

  public PageDto<Product> fromCategory (Page<Product> page){
    PageDto<Product> pageDto = new PageDto<>();
    pageDto.setContent(page.getContent());
    pageDto.setPageNumber(page.getNumber());
    pageDto.setPageSize(page.getSize());
    pageDto.setTotalPages(page.getTotalPages());
    pageDto.setTotalElements(page.getTotalElements());
    return pageDto;
  }
}
