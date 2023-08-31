package com.proyecto.ecommerce.service;

import com.proyecto.ecommerce.dto.OrderDto;
import com.proyecto.ecommerce.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
  String save(OrderDto orderDto);
}
