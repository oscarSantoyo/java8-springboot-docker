package ozz.com.products.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozz.com.dto.Product;
import ozz.com.products.models.ProductRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements ozz.com.products.service.ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), true)
                .map(product -> product.toDto()).collect(Collectors.toList());
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get().toDto();
    }
}
