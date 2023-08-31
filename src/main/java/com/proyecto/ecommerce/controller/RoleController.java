package com.proyecto.ecommerce.controller;

import com.proyecto.ecommerce.entity.Role;
import com.proyecto.ecommerce.error.ErrorResponse;
import com.proyecto.ecommerce.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("roles")
public class RoleController {
  private RoleService roleService;

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name){
    Role roleFound = roleService.getByName(name);

    return ResponseEntity.status(HttpStatus.OK).body(roleFound);
  }
  @PostMapping
  public ResponseEntity<?> saveRol (@RequestBody Role role ){
    System.out.println(role.getName());

    if(roleService.roleExistsByName(role.getName())){
      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setStatus(HttpStatus.CONFLICT.value());
      errorResponse.setError("Role Name Already Exists");
      errorResponse.setMessage("Role with name "+role.getName()+" already exists");
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
    Role roleSaved = roleService.save(role);
    return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
  }

}
