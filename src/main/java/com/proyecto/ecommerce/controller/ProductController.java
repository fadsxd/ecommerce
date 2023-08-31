package com.proyecto.ecommerce.controller;

import com.proyecto.ecommerce.dto.PageDto;
import com.proyecto.ecommerce.dto.ProductDto;
import com.proyecto.ecommerce.entity.Product;
import com.proyecto.ecommerce.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

  private ProductService productService;

  //TODO: CREAR PRODUCTO
  @PostMapping
  public ResponseEntity<Product> save(@RequestBody ProductDto dto) {
    Product productSaved = productService.save(dto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(productSaved);
  }

  //TODO: OBTEMER PRODUCTO ID
  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable UUID id) {
    Product productFound = productService.getById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productFound);
  }

  //TODO: ACTUALIZA UN PRODUCTO ID
  @PutMapping("/{id}")
  public ResponseEntity<Product> productUpdate(@PathVariable UUID id,
      @RequestBody ProductDto product) {
    Product productUpdate = productService.update(id, product);
    return ResponseEntity.status(HttpStatus.OK).body(productUpdate);
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProductPageable(@RequestParam int page,
      @RequestParam int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> productPage = productService.getProduct(pageable);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productPage);
  }

  @GetMapping
  public ResponseEntity<PageDto<Product>> getProductFiltered(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder
  ) {
    if (minPrice == null) {
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null) {
      maxPrice = Double.MAX_VALUE;
    }

    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);

    PageDto<Product> productPage = productService.getProductFilter(minPrice, maxPrice, pageable);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productPage);
  }

  //TODO: BUSCA POR CATEGORIA_ID FK CON PAGINADO
  @GetMapping("/category/{id}")
  public ResponseEntity<PageDto<Product>> getCategory(
      @PathVariable UUID id,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder
  ) {
    if (minPrice == null) {
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null) {
      maxPrice = Double.MAX_VALUE;
    }
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);
    PageDto<Product> categoryFound = productService.getCategoryId(id, minPrice, maxPrice,
        pageable);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(categoryFound);
  }

}
