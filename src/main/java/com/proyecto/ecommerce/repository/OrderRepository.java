package com.proyecto.ecommerce.repository;

import com.proyecto.ecommerce.entity.Order;
import com.proyecto.ecommerce.entity.OrderItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
