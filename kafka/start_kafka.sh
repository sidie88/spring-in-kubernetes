#!/bin/bash
cd config 
sed "s/localhost/$KAFKA_ZOOKEEPER_CONNECT_HOST/g" server.properties > server_active.properties
cd ../
exec bin/kafka-server-start.sh config/server_active.properties