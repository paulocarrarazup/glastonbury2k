package br.com.zup.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private UUID id;
    private String customerId;
    private BigDecimal amount;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<OrderItem> items;

    private String status;
}
