#!/usr/bin/env bash

for i in {1..20}; do
  for i in {1..15}; do
    curl http://localhost:8081/user-api/ --silent > /dev/null
    echo "/user-api/"
    sleep 1
  done
  curl http://localhost:8081/meow-api/ --silent > /dev/null
  echo "/meow-api/"
done
