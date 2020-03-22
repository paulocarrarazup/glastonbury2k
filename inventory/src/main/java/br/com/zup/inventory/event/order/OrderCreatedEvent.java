package br.com.zup.inventory.event.order;

import br.com.zup.inventory.enumeration.OrderStatus;
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
public class OrderCreatedEvent {

    private UUID orderId;
    private String customerId;
    private BigDecimal amount;
    private List<OrderCreatedItemEvent> items;
    private OrderStatus status;
}
