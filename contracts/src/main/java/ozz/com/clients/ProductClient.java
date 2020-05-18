package ozz.com.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Param;
import ozz.com.dto.Product;

import java.util.List;

@FeignClient(name = "product", url = "${external-system.product.url}")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/products/{productId}")
	Product getProduct(@PathVariable("productId") Long productId);
}
