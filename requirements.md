## Prerequisites

This page includes information of the requirements that are needed to install to follow this guide, basically this guide relies on the usage of Docker with docker-compose.

### Docker
- Docker (Desktop/Engine) (1.13.0+)
- docker-compose (latest)

### Docker Images
Please pull below docker images first to save time before running this guide. You can use different images version than this guide, but please be aware that there's maybe any changes between different version.

##### Elastic APM Stack

- APM Server

      docker pull docker.elastic.co/apm/apm-server:7.8.1

- Elasticsearch

      docker pull docker.elastic.co/elasticsearch/elasticsearch:7.8.1

- Kibana

      docker pull docker.elastic.co/kibana/kibana:7.8.1



##### Jaeger [Experemental: WIP]

- Jaeger all-in-one

      docker pull jaegertracing/all-in-one:1.18.1



##### APM Microservices Demo

- MongoDB

      docker pull mongo:4.4.0-bionic


- Frontend Home-UI (NodeJS-Express)

      docker pull heronimus/apm-app-homeui:0.0.1-elasticapm
      docker pull heronimus/apm-app-homeui:0.0.1-jaegerapm

- Backend Cloud Gateway (Spring Cloud Gateway)

      docker pull heronimus/apm-app-cloudgateway:0.0.1-elasticapm
      docker pull heronimus/apm-app-cloudgateway:0.0.1-jaegerapm

- Backend User Services (Spring Boot: Reactive MongoDB)

      docker pull heronimus/apm-app-userservices:0.0.1-elasticapm
      docker pull heronimus/apm-app-userservices:0.0.1-jaegerapm

- Backend Random Cat (Kocheng) (Python Flask)

      docker pull heronimus/apm-app-randomcat:0.0.1-elasticapm
      docker pull heronimus/apm-app-randomcat:0.0.1-jaegerapm
