package com.cxrus.microservices.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends 
	CassandraRepository<ExchangeValue, ExchangeKey> {
	
	@Query(allowFiltering = true)
	ExchangeValue findOneByKeyFromAndKeyTo(String from, String to);

}
