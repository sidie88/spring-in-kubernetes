#!/bin/bash
cd config 
if [ -z "$KAFKA_BROKER_ID" ]
then
      echo "\$KAFKA_BROKER_ID is empty"
	  KAFKA_BROKER_ID="0"
fi
if [ -z "$KAFKA_ZOOKEEPER_CONNECT_PORT" ]
then
      echo "\$KAFKA_ZOOKEEPER_CONNECT_PORT is empty"
	  KAFKA_ZOOKEEPER_CONNECT_PORT="2181"
fi
sed "s/\#listeners\=PLAINTEXT\:\/\/\:9092/listeners\=PLAINTEXT\:\/\/:9092/g; s/broker\.id\=0/broker.id\=$KAFKA_BROKER_ID/g; s/localhost/$KAFKA_ZOOKEEPER_CONNECT_HOST/g; s/2181/$KAFKA_ZOOKEEPER_CONNECT_PORT/g" server.properties > server_active.properties

cd ../
exec bin/kafka-server-start.sh config/server_active.properties