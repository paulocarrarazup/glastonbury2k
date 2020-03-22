package br.com.zup.order.service.translator;

import br.com.zup.order.domain.CreateOrderDomain;
import br.com.zup.order.domain.CreateOrderItemDomain;
import br.com.zup.order.gateway.database.entity.Order;
import br.com.zup.order.gateway.database.entity.OrderItem;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class CreateOrderDomainToOrderEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public Order translate(final CreateOrderDomain createOrderDomain) {

        MAPPER.typeMap(CreateOrderItemDomain.class, OrderItem.class)
                .addMapping(src -> src.getId(), OrderItem::setItemId);

        MAPPER.typeMap(CreateOrderItemDomain.class, OrderItem.class)
                .addMappings(mapper -> mapper.skip(OrderItem::setId));

        return MAPPER.map(createOrderDomain, Order.class);
    }

    public Order translate(final CreateOrderDomain createOrderDomain, Order createOrder) {

        MAPPER.typeMap(CreateOrderItemDomain.class, OrderItem.class)
                .addMapping(src -> src.getId(), OrderItem::setItemId);

        MAPPER.typeMap(CreateOrderItemDomain.class, OrderItem.class)
                .addMappings(mapper -> mapper.skip(OrderItem::setId));

        return MAPPER.map(createOrderDomain, Order.class);
    }
}
