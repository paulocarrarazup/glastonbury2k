package br.com.zup.order.service;

import br.com.zup.order.domain.CreateOrderDomain;
import br.com.zup.order.domain.CreatedOrderDomain;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    UUID create(CreateOrderDomain createOrderDomain);

    List<CreatedOrderDomain> findAll();

    UUID save(CreateOrderDomain createOrderDomain);

    UUID update(CreateOrderDomain createOrderDomain);

    CreatedOrderDomain findById(UUID orderId);
}
