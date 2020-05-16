package ozz.com.orders;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ozz.com.dto.Order;
import ozz.com.messaging.impl.ProducerMQ;
import ozz.com.orders.service.OrderService;

@RestController
public class Controller {
    @Autowired
    private ProducerMQ producerMQ;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders", produces = APPLICATION_JSON_VALUE)
    public Iterable<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping(value = "/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Order create(@RequestBody Order order) {
        Order created = orderService.create(order);
        producerMQ.send(created);
        return created;
    }
}
