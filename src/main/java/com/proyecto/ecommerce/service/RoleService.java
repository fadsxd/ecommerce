package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.entity.Role;

public interface RoleService {
  Role getByName(String name);

  Role save (Role role);

  boolean roleExistsByName(String name);
}
