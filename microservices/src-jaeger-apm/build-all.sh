#!/bin/bash

echo -e "\n\n--> Build: Backend Cloud Gateway .. \n"
cd app-backend-cloud-gateway
./mvnw-package.sh
docker build -t heronimus/apm-app-cloudgateway:0.0.1-jaegerapm .

echo -e "\n\n--> Build: Backend User Services .. \n"
cd ../app-backend-user-services
./mvnw-package.sh
docker build -t heronimus/apm-app-userservices:0.0.1-jaegerapm .

echo -e "\n\n--> Build: Backend Random Cat .. \n"
cd ../app-backend-random-cat
docker build -t heronimus/apm-app-randomcat:0.0.1-jaegerapm .

echo -e "\n\n--> Build: Frontend Home UI .. \n"
cd ../app-frontend-home-ui
docker build -t heronimus/apm-app-homeui:0.0.1-jaegerapm .


echo -e "\n\n--> Successfully build all demo microservices .. \n"
docker image ls | grep "jaegerapm"

echo -e "\n\n--> Push update \n"
docker push heronimus/apm-app-cloudgateway:0.0.1-jaegerapm
docker push heronimus/apm-app-userservices:0.0.1-jaegerapm
docker push heronimus/apm-app-randomcat:0.0.1-jaegerapm
docker push heronimus/apm-app-homeui:0.0.1-jaegerapm

echo -e "\nSUCCESS"
