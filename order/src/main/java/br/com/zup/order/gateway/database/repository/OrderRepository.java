package br.com.zup.order.gateway.database.repository;

import br.com.zup.order.gateway.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
