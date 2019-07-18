package com.cxrus.microservices.bloomberg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class MessageProducer {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
    @Autowired
    private KafkaTemplate<String, CrossCurrencies> crossCurrencyKafkaTemplate;

    @Value(value = "${currency.topic.name}")
    private String crossCurrencyTopicName;

    
    public void sendCrossCurrencyMessage(CrossCurrencies crossCurrency) {
    	crossCurrencyKafkaTemplate.send(crossCurrencyTopicName, crossCurrency);
    }
    
    public void sendMessage(String message) {
        
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(crossCurrencyTopicName, message);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
