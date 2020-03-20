package br.com.zup.order.orchestrator.event.inventory.publisher;

import br.com.zup.order.orchestrator.event.inventory.CreateInventoryEvent;
import br.com.zup.order.orchestrator.event.order.model.OrderRepresentation;
import br.com.zup.order.orchestrator.event.translator.OrderRepresentationToCreateInventoryEventTranslator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateInventoryEventPublisher {

    private KafkaTemplate<String, CreateInventoryEvent> template;

    public CreateInventoryEventPublisher(KafkaTemplate<String, CreateInventoryEvent> template) {
        this.template = template;
    }

    public void publish(final OrderRepresentation orderRepresentation) {

        CreateInventoryEvent event = OrderRepresentationToCreateInventoryEventTranslator.translate(orderRepresentation);

        this.template.send("create-inventory", event);
    }
}
