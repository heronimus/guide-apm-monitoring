#!/usr/bin/env bash

for i in {1..10}; do
  curl -d '{"name":"User '${i}'", "email":"user@mail.com"}' -H "Content-Type: application/json" -X POST http://localhost:8081/user-api/
  echo
done
