package ozz.com.messaging.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ozz.com.dto.Order;

@Component
public class ConsumerMQ {
    @Autowired
    private MessageStorage consumerStorage;

    @JmsListener(destination = "${order.mq.queue}", containerFactory = "jsaFactory")
    public void receive(Order order){
        System.out.println("Received message: "+order);
        consumerStorage.add(order);
    }

}
