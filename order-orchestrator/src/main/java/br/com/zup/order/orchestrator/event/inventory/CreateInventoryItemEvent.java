package br.com.zup.order.orchestrator.event.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInventoryItemEvent {
    private UUID id;
    private String name;
    private BigDecimal amount;
    private Integer quantity;
}
