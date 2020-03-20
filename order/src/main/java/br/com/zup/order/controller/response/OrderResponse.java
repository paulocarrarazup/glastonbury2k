package br.com.zup.order.controller.response;

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
public class OrderResponse {

    private String id;
    private String customerId;
    private BigDecimal amount;
    private List<OrderItemResponse> items;
    private String status;
}
