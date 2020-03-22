package br.com.zup.order.service.impl;

import br.com.zup.order.domain.CreateOrderDomain;
import br.com.zup.order.domain.CreatedOrderDomain;
import br.com.zup.order.event.order.publisher.OrderCreatedEventPublisher;
import br.com.zup.order.exception.OrderNotFoundException;
import br.com.zup.order.gateway.database.entity.Order;
import br.com.zup.order.gateway.database.repository.OrderRepository;
import br.com.zup.order.service.OrderService;
import br.com.zup.order.service.translator.CreateOrderDomainToOrderEntityTranslator;
import br.com.zup.order.service.translator.OrderEntityToCreatedOrderDomainTranslator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderCreatedEventPublisher orderCreatedEventPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, OrderCreatedEventPublisher orderCreatedEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderCreatedEventPublisher = orderCreatedEventPublisher;
    }

    @Transactional
    @Override
    public UUID create(CreateOrderDomain createOrderDomain) {
        UUID orderId = save(createOrderDomain);
        createOrderDomain.setId(orderId);

        orderCreatedEventPublisher.publish(createOrderDomain);

        return orderId;
    }

    @Override
    public UUID save(CreateOrderDomain createOrderDomain) {

        final Order savedOrder = CreateOrderDomainToOrderEntityTranslator.translate(createOrderDomain);

        return this.orderRepository.save(savedOrder).getId();
    }

    @Override
    public UUID update(CreateOrderDomain createOrderDomain) {
        final Order retrievedOrder = this.orderRepository.findById(createOrderDomain.getId())
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order not found: %s", createOrderDomain.getId())));

        final Order updatedOrder = CreateOrderDomainToOrderEntityTranslator.translate(createOrderDomain, retrievedOrder);

        return this.orderRepository.save(updatedOrder).getId();
    }

    @Override
    public List<CreatedOrderDomain> findAll() {
        return this.orderRepository.findAll()
                .stream()
                .map(OrderEntityToCreatedOrderDomainTranslator::translate)
                .collect(Collectors.toList());
    }

    @Override
    public CreatedOrderDomain findById(UUID orderId) {
        final Order retrievedOrder = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order not found: %s", orderId)));

        return OrderEntityToCreatedOrderDomainTranslator.translate(retrievedOrder);
    }
}