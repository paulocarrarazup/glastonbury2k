package br.com.zup.order.controller.translator;

import br.com.zup.order.controller.response.OrderResponse;
import br.com.zup.order.domain.CreatedOrderDomain;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@UtilityClass
public class CreatedOrderDomainToOrderResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public OrderResponse translate(CreatedOrderDomain createdOrderDomain) {
        return MAPPER.map(createdOrderDomain, OrderResponse.class);
    }
}
