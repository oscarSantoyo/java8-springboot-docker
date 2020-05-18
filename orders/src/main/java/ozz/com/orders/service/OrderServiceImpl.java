package ozz.com.orders.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ozz.com.dto.Order;
import ozz.com.dto.OrderUpdate;
import ozz.com.orders.models.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), true).map(order -> order.toDto())
            .collect(Collectors.toList());
    }

    @Override
    public Order create(Order order) {
        ozz.com.orders.models.Order toSave = new ozz.com.orders.models.Order(order.getId(), order.getName(),
                                                                             order.getProductId());

        return orderRepository.save(toSave).toDto();
    }

    @Override
    public void newUpdate(OrderUpdate orderUpdate) {
        logger.debug("New update received: {}", orderUpdate);
    }
}
