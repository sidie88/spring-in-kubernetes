package com.cxrus.rnd.microsvc.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<OrderServiceDto, Long> {

}
