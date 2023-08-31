package com.proyecto.ecommerce.controller;

import com.proyecto.ecommerce.dto.OrderDto;
import com.proyecto.ecommerce.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {
  private OrderService orderService;

  @PostMapping
  private ResponseEntity<String> save(@RequestBody OrderDto orderDto){
    String message = orderService.save(orderDto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(message);
  }
}
