package br.com.zup.order.event.inventory;

import br.com.zup.order.enumeration.OrderStatus;
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
public class InventoryRejectedEvent {

    private String orderId;
    private String customerId;
    private BigDecimal amount;
    private List<InventoryItemRejectedEvent> items;
    private OrderStatus status;
}
