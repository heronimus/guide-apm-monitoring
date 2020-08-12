#!/usr/bin/env bash

APM_HOST=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' guide-apm-monitoring_apm_1)
APM_HOST=${APM_HOST}:8200

java -Xms128m -Xmx256m \
     -javaagent:./elastic-apm-agent-1.16.1-SNAPSHOT.jar \
     -Delastic.apm.service_name=cloud-gateway2 \
     -Delastic.apm.server_urls=http://${APM_HOST} \
     -Delastic.apm.application_packages=com.heronimus \
     -jar ./target/cloudgateway-0.0.1-SNAPSHOT.jar
