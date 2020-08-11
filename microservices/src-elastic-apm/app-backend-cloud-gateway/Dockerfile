FROM openjdk:11-jre-slim

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY target/cloudgateway-0.0.1-SNAPSHOT.jar .
COPY elastic-apm-agent-1.16.1-WEBFLUX.jar .
COPY docker-cmd.sh .

RUN chmod +x /opt/app/docker-cmd.sh
EXPOSE 8080

CMD ["/opt/app/docker-cmd.sh"]
