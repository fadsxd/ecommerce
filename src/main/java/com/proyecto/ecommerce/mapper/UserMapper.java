package com.proyecto.ecommerce.mapper;

import com.proyecto.ecommerce.dto.UserDto;
import com.proyecto.ecommerce.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public UserDto fromUserDto(User user){
    UserDto userDto = new UserDto();
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setAddress(user.getAddress());
    userDto.setEmail(user.getEmail());
    userDto.setRoleName(user.getRole().getName());
    return userDto;
  }
}
