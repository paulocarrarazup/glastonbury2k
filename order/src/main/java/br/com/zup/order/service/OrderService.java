package br.com.zup.order.service;

import br.com.zup.order.domain.CreateOrderDomain;
import br.com.zup.order.domain.CreatedOrderDomain;

import java.util.List;

public interface OrderService {

    String create(CreateOrderDomain createOrderDomain);

    List<CreatedOrderDomain> findAll();

    String save(CreateOrderDomain createOrderDomain);
}
