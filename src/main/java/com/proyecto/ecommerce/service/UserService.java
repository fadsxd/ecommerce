package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.dto.UserDto;
import java.util.UUID;

public interface UserService {

  UserDto getById(UUID id);


}
