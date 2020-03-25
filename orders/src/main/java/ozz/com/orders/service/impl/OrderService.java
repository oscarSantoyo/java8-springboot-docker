package ozz.com.orders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozz.com.dto.Order;
import ozz.com.messaging.impl.OrderMQ;
import ozz.com.orders.models.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService implements ozz.com.orders.service.OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMQ orderMQ;

    @Override
    public List<Order> getAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), true)
                .map(order -> order.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public Order create(Order order) {
        ozz.com.orders.models.Order toSave = new ozz.com.orders.models.Order(order.getId(), order.getName(), order.getProductId());

        return orderRepository.save(toSave).toDto();
    }
}