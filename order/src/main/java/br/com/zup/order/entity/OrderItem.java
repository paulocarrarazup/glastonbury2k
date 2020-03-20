package br.com.zup.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;
    private String itemId;
    private String name;
    private BigDecimal amount;
    private Integer quantity;
}
