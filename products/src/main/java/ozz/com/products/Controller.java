package ozz.com.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ozz.com.products.models.Product;
import ozz.com.products.models.ProductRepository;

@RestController
public class Controller {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

}
