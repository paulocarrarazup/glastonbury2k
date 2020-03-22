package br.com.zup.order.gateway.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID itemId;
    private String name;
    private BigDecimal amount;
    private Integer quantity;
}
