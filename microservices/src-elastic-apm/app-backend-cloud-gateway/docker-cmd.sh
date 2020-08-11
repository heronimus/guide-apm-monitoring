#!/usr/bin/env bash

java -Xms128m -Xmx256m \
     -javaagent:/opt/app/elastic-apm-agent-1.16.1-WEBFLUX.jar \
     -Delastic.apm.service_name=cloud-gateway \
     -Delastic.apm.server_urls=http://${APM_HOST} \
     -Delastic.apm.application_packages=com.heronimus.apm \
     -jar /opt/app/cloudgateway-0.0.1-SNAPSHOT.jar
