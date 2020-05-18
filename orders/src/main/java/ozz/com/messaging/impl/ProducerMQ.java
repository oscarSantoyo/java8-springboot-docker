package ozz.com.messaging.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import ozz.com.dto.Order;
import ozz.com.dto.Product;

@Component
public class ProducerMQ {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${new-order.mq.queue}")
    private String queue;

    @Value("${product-sell.mq.queue}")
	private String productSellMQ;

    public void send(Order order){
        jmsTemplate.convertAndSend(queue, order);
    }

    public void send(Product product){
        jmsTemplate.convertAndSend(productSellMQ, product);
    }

}
