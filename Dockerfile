# Docker image for microservicedemo

FROM registry.devapp.tradedoubler.com/tradedoubler/baseimage:oraclejdk8_66

MAINTAINER ikeadev@tradedoubler.com

ADD service/service.sh /etc/service/microservicedemo/run
ADD target/microservicedemo*.jar /microservicedemo.jar

CMD chmod +x /etc/service/microservicedemo/run && exec /sbin/my_init