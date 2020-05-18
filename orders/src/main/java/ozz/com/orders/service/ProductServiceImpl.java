package ozz.com.orders.service;

import org.springframework.stereotype.Service;

import ozz.com.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public void productSell(Product product) {
		System.out.println("New product sold:" + product);
	}

}
