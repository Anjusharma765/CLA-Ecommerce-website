package com.art.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.art.model.Product;

@FeignClient(name = "ADMIN-SERVICE", url = "http://localhost:8085")
public interface ProductService {

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id);

}
