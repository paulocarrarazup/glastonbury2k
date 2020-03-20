package br.com.zup.order.orchestrator.event.translator;

import br.com.zup.order.orchestrator.event.inventory.CreateInventoryEvent;
import br.com.zup.order.orchestrator.event.order.model.OrderRepresentation;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class OrderRepresentationToCreateInventoryEventTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public CreateInventoryEvent translate(final OrderRepresentation orderRepresentation) {
        return MAPPER.map(orderRepresentation, CreateInventoryEvent.class);
    }
}
