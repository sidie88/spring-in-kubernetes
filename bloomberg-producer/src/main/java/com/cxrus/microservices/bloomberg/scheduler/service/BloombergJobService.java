package com.cxrus.microservices.bloomberg.scheduler.service;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.cxrus.microservices.bloomberg.BloombergServiceProxy;
import com.cxrus.microservices.bloomberg.CrossCurrencies;
import com.cxrus.microservices.bloomberg.MessageProducer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;

@Service
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class})
public class BloombergJobService {

    private Logger logger = LoggerFactory.getLogger(BloombergJobService.class);
    
    private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    @Autowired
    private BloombergServiceProxy proxy;

    @Autowired
    private MessageProducer producer;

    @Value(value = "${bloomberg.rapid.api.host}")
	private String apiHost;

    @Value(value = "${bloomberg.rapid.api.key}")
	private String apiKey;

    @Value(value = "${bloomberg.rapid.api.currencies.id}")
	private String id;

    @Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapServers;
    
    @Value(value = "${currency.topic.name}")
    private String crossCurrencyTopicName;
    
//    public KafkaProducer<String, String> createKafkaProducer(){
//
//        // create Producer properties
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        
//        // create the producer
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
//        return producer;
//    }
    
    public void executeBloombergJob() {

        logger.info("The sample job has begun...");	
        try {
        	
        	// create a kafka producer
//            KafkaProducer<String, String> producer = createKafkaProducer();
        	
        	String currenciesId = URLEncoder.encode(id, StandardCharsets.UTF_8.toString());
			Response response = proxy.getCrossCurrencies(apiHost, apiKey, currenciesId);
        	InputStream body = response.body().asInputStream();
        	String content = StreamUtils.copyToString(body, StandardCharsets.UTF_8);
        	
        	JSONObject jsonObject  = new JSONObject(content.replace(":cur", ""));
        	
        	JSONObject result = jsonObject.getJSONObject("result");
        	logger.info("response : " + result.toString(1));
        	
        	// add a shutdown hook
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                logger.info("stopping application...");
//                logger.info("closing producer...");
//                producer.close();
//                logger.info("done!");
//            }));
        	
        	Iterator<String> keys = result.keys();
        	while(keys.hasNext()) {
        	    String key = keys.next();
				if (result.get(key) instanceof JSONObject) {
        	    	JSONObject currencyExchange = (JSONObject) result.get(key);
					logger.info("json object : " + currencyExchange.toString(1));
        	    	
        	    	producer.sendMessage(currencyExchange.toString(1));
        	    	
//					producer.send(new ProducerRecord<>(crossCurrencyTopicName, null, currencyExchange.toString(1)), new Callback() {
//	                    @Override
//	                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
//	                        if (e != null) {
//	                            logger.error("Something bad happened", e);
//	                        }
//	                    }
//	                });
        	    	
        	    }
        	}
        	
            Thread.sleep(5000);
        } catch (Exception e) {
            logger.error("Error while executing sample job", e);
        } finally {
            logger.info("Sample job has finished...");
        }
    }
}
