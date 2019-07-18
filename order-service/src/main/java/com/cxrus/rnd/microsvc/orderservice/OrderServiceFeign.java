package com.cxrus.rnd.microsvc.orderservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
@RibbonClient(name="product-service")
public interface OrderServiceFeign {
	@GetMapping("/product-service/all")
	public List<ProductServiceDto> retrieveAllOrder();
	
	@GetMapping("/product-service/id/{id}")
	public ProductServiceDto retrieveOrderById(@PathVariable("id") String id);
}
