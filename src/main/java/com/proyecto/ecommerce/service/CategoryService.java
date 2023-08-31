package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    List<Category> getAll();

    Category getById(UUID id);


}
