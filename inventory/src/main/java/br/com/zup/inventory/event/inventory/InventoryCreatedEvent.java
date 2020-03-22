package br.com.zup.inventory.event.inventory;

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
public class InventoryCreatedEvent {

    private UUID orderId;
    private String customerId;
    private BigDecimal amount;
    private List<InventoryItemCreatedEvent> items;
    private OrderStatus status;
}
