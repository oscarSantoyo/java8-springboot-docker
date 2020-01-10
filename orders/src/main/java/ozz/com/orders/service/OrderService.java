package ozz.com.orders.service;

import ozz.com.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order create(Order order);
}
