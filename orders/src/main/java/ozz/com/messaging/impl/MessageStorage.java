package ozz.com.messaging.impl;

import org.checkerframework.checker.units.qual.C;
import ozz.com.dto.Order;

import java.util.ArrayList;
import java.util.List;

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
