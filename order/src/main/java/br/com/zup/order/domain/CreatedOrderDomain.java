package br.com.zup.order.domain;

import br.com.zup.order.enumeration.OrderStatus;
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
public class CreatedOrderDomain {

    private String id;
    private String customerId;
    private BigDecimal amount;
    private OrderStatus status;
    private List<CreatedOrderItemDomain> items;
}
