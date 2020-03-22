package br.com.zup.order.controller;

import br.com.zup.order.controller.request.CreateOrderRequest;
import br.com.zup.order.controller.response.OrderResponse;
import br.com.zup.order.controller.translator.CreateOrderRequestToCreateOrderDomainTranslator;
import br.com.zup.order.controller.translator.CreatedOrderDomainToOrderResponseTranslator;
import br.com.zup.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UUID create(@RequestBody CreateOrderRequest request) {
        return this.orderService.create(CreateOrderRequestToCreateOrderDomainTranslator.translate(request));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public List<OrderResponse> getOrders() {
        return this.orderService.findAll()
                .stream()
                .map(CreatedOrderDomainToOrderResponseTranslator::translate)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public OrderResponse getOrderById(@PathVariable("id") final UUID id) {
        return CreatedOrderDomainToOrderResponseTranslator.translate(this.orderService.findById(id));
    }
}