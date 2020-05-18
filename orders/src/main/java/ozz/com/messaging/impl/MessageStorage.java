package ozz.com.messaging.impl;

import java.util.ArrayList;
import java.util.List;

import ozz.com.dto.Order;

public class MessageStorage {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void clear(){
        orders.clear();
    }

    public List<Order> getAll(){
        return orders;
    }
}
