package br.com.zup.order.orchestrator.event.inventory;

import br.com.zup.order.orchestrator.OrderStatus;
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
public class CreateInventoryEvent {

    private String orderId;
    private String customerId;
    private BigDecimal amount;
    private List<CreateInventoryItemEvent> items;
    private OrderStatus status;
}
