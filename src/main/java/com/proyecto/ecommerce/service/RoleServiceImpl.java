package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.entity.Role;
import com.proyecto.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{
  private RoleRepository roleRepository;
  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("ROL NO ENCONTRADO"));
  }

  @Override
  public Role save(Role role) {
    return roleRepository.save(role);

  }

  public boolean roleExistsByName(String roleName){
    return roleRepository.existsByName(roleName);
  }


}
