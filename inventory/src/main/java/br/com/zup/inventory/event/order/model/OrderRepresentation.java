package br.com.zup.inventory.event.order.model;

import br.com.zup.inventory.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRepresentation {

    private String orderId;
    private String customerId;
    private BigDecimal amount;
    private List<OrderItemRepresentation> items;
    private OrderStatus status;
}
