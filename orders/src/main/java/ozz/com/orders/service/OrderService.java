package ozz.com.orders.service;

import java.util.List;

import ozz.com.dto.Order;
import ozz.com.dto.OrderUpdate;

public interface OrderService {
    List<Order> getAll();

    Order create(Order order);

    void newUpdate(OrderUpdate orderUpdate);

}
