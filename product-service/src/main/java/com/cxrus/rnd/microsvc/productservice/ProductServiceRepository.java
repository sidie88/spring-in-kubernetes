package com.cxrus.rnd.microsvc.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository extends JpaRepository<ProductServiceDto, Long> {

}
