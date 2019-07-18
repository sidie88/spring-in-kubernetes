package com.cxrus.rnd.microsvc.orderservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderServiceFeign orderServiceFeign;
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@GetMapping("/order-service/all")
	public List<OrderServiceDto> getOrderWithTotal() {

		List<OrderServiceDto> orderServiceDtosRes = new ArrayList<OrderServiceDto>();
		List<OrderServiceDto> orderServiceDtos = orderServiceRepository.findAll();
		
		for (OrderServiceDto orderServiceDto : orderServiceDtos) {
			ProductServiceDto productServiceDtos = orderServiceFeign.retrieveOrderById(String.valueOf(orderServiceDto.getProductId()));
			BigDecimal resTotal = productServiceDtos.getPrice().multiply(new BigDecimal(orderServiceDto.getQuantity()));
			orderServiceDto.setTotalPrice(resTotal);
			orderServiceDtosRes.add(orderServiceDto);
		}

		logger.info("{}", orderServiceDtosRes);

		return orderServiceDtosRes;
	}
	
	@GetMapping("/order-service/id/{id}")
	public OrderServiceDto findById(@PathVariable long id) {
		OrderServiceDto orderServiceDto = orderServiceRepository.findById(id).get();
		logger.info("{}", orderServiceDto);
		return orderServiceDto;
	}
	
	@PostMapping("/order-service")
	public OrderServiceDto createOrder(@RequestBody OrderServiceDto orderServiceDtoReq) {
		OrderServiceDto orderServiceDtoRes = orderServiceRepository.save(orderServiceDtoReq);
		logger.info("{}", orderServiceDtoRes);
		return orderServiceDtoRes;
	}
	
	@PutMapping("/order-service")
	public ResponseEntity<Object> updateOrder(@RequestBody OrderServiceDto orderServiceDtoReq, @PathVariable long id) {
		Optional<OrderServiceDto> orderServiceDtoOptional = orderServiceRepository.findById(id);
		if (!orderServiceDtoOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		orderServiceDtoReq.setId(id);
		OrderServiceDto orderServiceDtoRes = orderServiceRepository.save(orderServiceDtoReq);
		logger.info("{}", orderServiceDtoRes);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/order-service/id/{id}")
	public void deleteById(@PathVariable long id) {
		orderServiceRepository.deleteById(id);
	}
	
}
