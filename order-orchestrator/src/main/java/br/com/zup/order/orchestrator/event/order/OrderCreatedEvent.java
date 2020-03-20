package br.com.zup.order.orchestrator.event.order;

import br.com.zup.order.orchestrator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreatedEvent {

    private String orderId;
    private String customerId;
    private BigDecimal amount;
    private List<OrderCreatedItemEvent> items;
    private OrderStatus status;
}