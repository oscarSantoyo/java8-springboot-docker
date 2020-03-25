package ozz.com.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozz.com.clients.ProductClient;
import ozz.com.dto.Order;
import ozz.com.messaging.impl.MessageStorage;
import ozz.com.messaging.impl.ProducerMQ;
import ozz.com.orders.service.OrderService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Controller {
    @Autowired
    private ProducerMQ producerMQ;

    @Autowired
    private MessageStorage messageStorage;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders", produces = APPLICATION_JSON_VALUE)
    public Iterable<Order> getAll() {
        System.out.println(productClient.getAll());
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
