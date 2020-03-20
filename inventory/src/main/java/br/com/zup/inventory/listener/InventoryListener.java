package br.com.zup.inventory.listener;

import br.com.zup.inventory.configuration.KafkaConfiguration;
import br.com.zup.inventory.event.order.OrderCreatedEvent;
import br.com.zup.inventory.event.order.model.OrderRepresentation;
import br.com.zup.inventory.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InventoryListener {

    private ObjectMapper objectMapper;
    private static final ModelMapper MAPPER = new ModelMapper();
    private InventoryService inventoryService;

    public InventoryListener(ObjectMapper objectMapper, InventoryService inventoryService, KafkaConfiguration kafkaConfiguration) {
        this.objectMapper = objectMapper;
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "create-inventory", groupId = KafkaConfiguration.CONSUMER_GROUP)
    public void listen(String message) throws IOException {
        OrderCreatedEvent event = this.objectMapper.readValue(message, OrderCreatedEvent.class);

        OrderRepresentation orderRepresentation = MAPPER.map(event, OrderRepresentation.class);

        inventoryService.checkAvailableTickets(orderRepresentation);
        System.out.println("Received event OrderListener: " + event.getCustomerId());
    }
}
