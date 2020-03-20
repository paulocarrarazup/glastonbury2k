package br.com.zup.order.orchestrator.event.translator;

import br.com.zup.order.orchestrator.event.order.OrderCreatedEvent;
import br.com.zup.order.orchestrator.event.order.model.OrderRepresentation;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@UtilityClass
public class OrderCreateEventToOrderRepresentationTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public OrderRepresentation translate(final OrderCreatedEvent orderCreatedEvent) {
        return MAPPER.map(orderCreatedEvent, OrderRepresentation.class);
    }
}
