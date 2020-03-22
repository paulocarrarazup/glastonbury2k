package br.com.zup.inventory.gateway.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity(name = "t_inventory")
public class Inventory {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "item_id")
    private UUID itemId;

    private Integer quantity;
}
