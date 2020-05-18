package ozz.com.orders.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ozz.com.clients.ProductClient;
import ozz.com.dto.Order;
import ozz.com.dto.Product;
import ozz.com.messaging.impl.ProducerMQ;

@Service
public class PaymentServiceImpl implements PaymentService {
    private Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private ProducerMQ producerMQ;
    @Autowired
    private ProductClient productClient;

    @Override
    public void newOrder(Order order) {
        logger.debug("New order received: {}", order);
        Assert.notNull(order,"Order cannot be null");
        Assert.notNull(order.getProductId(), "order.product cannot be null");

        Product productResult = productClient.getProduct(order.getProductId());
        Assert.notNull(productResult,"ProductResult cannot be null");
        producerMQ.send(productResult);
        System.out.println("New order received: "+order);
	}
}
