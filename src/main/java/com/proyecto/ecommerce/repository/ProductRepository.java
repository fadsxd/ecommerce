package com.proyecto.ecommerce.repository;

import com.proyecto.ecommerce.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


  @Query(value = "SELECT * FROM products WHERE category_id = ?1",nativeQuery = true)
  Page<Product>findByCategory(String id,Double minPrice,Double maxPrice, Pageable pageable);

  Page<Product> findByPriceBetween(Double minPrice,Double maxPrice, Pageable pageable);

  /*
  List<Product> findAllById(UUID id);
  */

  /*
  //TODO: QUERY NATIVA
  @Query(value = "SELECT * FROM products WHERE category_id = ?1",nativeQuery = true)
  Optional<Product> findCategoryId(UUID id);

   */
}
