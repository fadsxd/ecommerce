package com.proyecto.ecommerce.dto;

import com.proyecto.ecommerce.entity.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String roleName;
}
