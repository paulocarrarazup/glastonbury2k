package br.com.zup.inventory.gateway.database.repository;

import br.com.zup.inventory.gateway.database.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

        Optional<Inventory> findByItemId(UUID itemId);
}
