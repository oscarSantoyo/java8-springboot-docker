package ozz.com.orders.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import ozz.com.orders.models.Order;

@Service
public interface OrderRepository extends CrudRepository<Order, Long> {

}
