package ozz.com.products.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
