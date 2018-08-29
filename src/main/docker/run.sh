#!/bin/sh

echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z eurekaserver  $EUREKASERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Waiting for the authdatabase server to start on port $DATABASESERVER_PORT"
echo "********************************************************"
while ! `nc -z authdb $DATABASESERVER_PORT`; do sleep 3; done
echo "******** AuthDB Server has started "

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z configserver $CONFIGSERVER_PORT`; do sleep 3; done
echo "*******  Configuration Server has started"

echo "********************************************************"
echo "Waiting for the zuul server to start on port $ZUULSERVER_PORT)"
echo "********************************************************"
while ! `nc -z zuulserver $ZUULSERVER_PORT`; do sleep 3; done
echo "******** Zuul Server has started "

echo "********************************************************"
echo "Starting Auth Server with Configuration Service via Eureka :  $EUREKASERVER_URI" ON PORT: $SERVER_PORT;
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
-Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI             \
-Dspring.cloud.config.uri=$CONFIGSERVER_URI                          \
-Dspring.profiles.active=$PROFILE -jar /usr/local/authservice/@project.build.finalName@.jar
