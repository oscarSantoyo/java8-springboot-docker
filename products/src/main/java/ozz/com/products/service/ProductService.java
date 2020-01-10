package ozz.com.products.service;

import ozz.com.dto.Product;

public interface ProductService {
    Iterable<Product> getAll();
    Product getById(Long id);
}
