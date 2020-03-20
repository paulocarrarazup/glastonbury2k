package br.com.zup.order.orchestrator.task;

import br.com.zup.order.orchestrator.event.inventory.publisher.CreateInventoryEventPublisher;
import br.com.zup.order.orchestrator.event.order.OrderCreatedEvent;
import br.com.zup.order.orchestrator.event.translator.OrderCreateEventToOrderRepresentationTranslator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class BookingTask implements JavaDelegate{

    private ObjectMapper objectMapper;
    private CreateInventoryEventPublisher createInventoryEventPublisher;

    public BookingTask(ObjectMapper objectMapper, CreateInventoryEventPublisher createInventoryEventPublisher) {
        this.objectMapper = objectMapper;
        this.createInventoryEventPublisher = createInventoryEventPublisher;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String orderVariable = (String)delegateExecution.getVariable("ORDER");
        OrderCreatedEvent event = this.objectMapper.readValue(orderVariable, OrderCreatedEvent.class);

        createInventoryEventPublisher.publish(OrderCreateEventToOrderRepresentationTranslator.translate(event));
    }
}
