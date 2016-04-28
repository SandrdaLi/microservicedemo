#!/bin/sh
java ${JAVA_OPTS} -jar /microservicedemo.jar --spring.profiles.active=$APP_PROFILE 2>&1