package br.com.zup.order.service.translator;

import br.com.zup.order.domain.CreatedOrderDomain;
import br.com.zup.order.domain.CreatedOrderItemDomain;
import br.com.zup.order.gateway.database.entity.Order;
import br.com.zup.order.gateway.database.entity.OrderItem;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class OrderEntityToCreatedOrderDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public CreatedOrderDomain translate(final Order order) {

        MAPPER.typeMap(OrderItem.class, CreatedOrderItemDomain.class)
                .addMapping(src -> src.getItemId(), CreatedOrderItemDomain::setId);

        return MAPPER.map(order, CreatedOrderDomain.class);
    }
}
