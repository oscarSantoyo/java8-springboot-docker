package ozz.com.messaging.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ozz.com.dto.Order;
import ozz.com.dto.Product;
import ozz.com.orders.service.OrderService;
import ozz.com.orders.service.PaymentService;
import ozz.com.orders.service.ProductService;

@Component
public class HandlerMQ {
    // @Autowired
    // private MessageStorage consumerStorage;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${new-order.mq.queue}")
    private String newOrderQueue;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    // @JmsListener(destination = "${order.mq.queue}", containerFactory = "jsaFactory")
    // public void receive(Order order){
        // System.out.println("Received message: "+order);
        // consumerStorage.add(order);
    // }

    @JmsListener(destination = "${order-updates.mq.queue}", containerFactory = "jsaFactory")
    public void orderUpdates(ozz.com.dto.OrderUpdate orderUpdate){
        orderService.newUpdate(orderUpdate);
    }
    
    @JmsListener(destination = "${new-order.mq.queue}", containerFactory = "jsaFactory")
    public void listenNewOrder(Order order) {
        paymentService.newOrder(order);
    }

    @JmsListener(destination = "${product-sell.mq.queue}", containerFactory = "jsaFactory")
    public void listenProductSell(Product product) {
        productService.productSell(product);
    }

    //@Value("${product-sell.mq.queue}")

    public boolean sendNewOrder(Order order){
        jmsTemplate.convertAndSend(order);
        return true;
    }



}
