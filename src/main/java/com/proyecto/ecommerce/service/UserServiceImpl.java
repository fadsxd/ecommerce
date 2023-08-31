package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.dto.UserDto;
import com.proyecto.ecommerce.entity.Product;
import com.proyecto.ecommerce.entity.User;
import com.proyecto.ecommerce.mapper.UserMapper;
import com.proyecto.ecommerce.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;
  private UserMapper userMapper;

  @Override
  public UserDto getById(UUID id) {
    User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("USUARIO NO ENCONTRADO"));
    return userMapper.fromUserDto(user);
  }
}
