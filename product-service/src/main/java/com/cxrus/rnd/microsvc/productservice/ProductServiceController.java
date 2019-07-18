package com.cxrus.rnd.microsvc.productservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private ProductServiceRepository productServiceRepository;

	@GetMapping("/product-service/all")
	public List<ProductServiceDto> findAll() {
		List<ProductServiceDto> productServiceDtos = productServiceRepository.findAll();
		return productServiceDtos;
	}

	@GetMapping("/product-service/id/{id}")
	public ProductServiceDto findById(@PathVariable long id) {
		ProductServiceDto productServiceDto = productServiceRepository.findById(id).get();
		productServiceDto.setPort(environment.getProperty("local.server.port"));
		logger.info("{}", productServiceDto);
		return productServiceDto;
	}

	@PostMapping("/product-service")
	public ProductServiceDto createProduct(@RequestBody ProductServiceDto productServiceDto) {
		ProductServiceDto productServiceDtoRes = productServiceRepository.save(productServiceDto);
		productServiceDtoRes.setPort(environment.getProperty("local.server.port"));
		logger.info("{}", productServiceDtoRes);
		return productServiceDtoRes;
	}

	@PutMapping("/product-service/id/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductServiceDto productServiceDtoReq,
			@PathVariable long id) {
		Optional<ProductServiceDto> productServiceDtoOptional = productServiceRepository.findById(id);
		if (!productServiceDtoOptional.isPresent())
			return ResponseEntity.notFound().build();

		productServiceDtoReq.setId(id);
		productServiceRepository.save(productServiceDtoReq);
		productServiceDtoReq.setPort(environment.getProperty("local.server.port"));
		logger.info("{}", productServiceDtoReq);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/product-service/id/{id}")
	public void deleteById(@PathVariable long id) {
		productServiceRepository.deleteById(id);
	}

}
