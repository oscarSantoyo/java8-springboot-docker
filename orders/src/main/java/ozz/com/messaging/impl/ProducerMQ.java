package ozz.com.messaging.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ozz.com.dto.Order;

@Component
public class ProducerMQ {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${order.mq.queue}")
    private String queue;

    public void send(Order order){
        jmsTemplate.convertAndSend(queue, order);
    }

}
