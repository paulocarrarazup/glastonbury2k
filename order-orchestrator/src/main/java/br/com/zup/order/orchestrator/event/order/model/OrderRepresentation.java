package br.com.zup.order.orchestrator.event.order.model;

import br.com.zup.order.orchestrator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRepresentation {

    private UUID orderId;
    private String customerId;
    private BigDecimal amount;
    private List<OrderItemRepresentation> items;
    private OrderStatus status;
}
