package ozz.com.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ozz.com.dto.Product;
import ozz.com.products.service.ProductService;

@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{productId}")
    public Product get(@PathVariable Long productId) {
        return productService.getById(productId);
    }

}
