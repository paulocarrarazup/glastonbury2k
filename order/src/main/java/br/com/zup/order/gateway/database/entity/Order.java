package br.com.zup.order.gateway.database.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "t_order")
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

    @CreationTimestamp
    private Date createdAt;
}
