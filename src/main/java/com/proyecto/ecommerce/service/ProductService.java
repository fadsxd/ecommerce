package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.dto.PageDto;
import com.proyecto.ecommerce.dto.ProductDto;
import com.proyecto.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product save(ProductDto product);

    Product getById(UUID id);

    Product update(UUID id,ProductDto product);

    Page<Product> getProduct(Pageable pageable);

    PageDto<Product> getProductFilter(Double minPrice,Double MaxPrice,Pageable pageable);


    //Page<Product> getCategory(Pageable pageable, UUID id);
    PageDto<Product> getCategoryId(UUID id,Double minPrice,Double MaxPrice,Pageable pageable);



}
