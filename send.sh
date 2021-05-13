#!/bin/bash

SPRING_BOOT_REST=$1

if [ "${SPRING_BOOT_REST}" == "" ]; then
  echo "SPRING_BOOT_REST is required."
  exit 1;
fi

curl -v ${SPRING_BOOT_REST}/host/info
curl -v ${SPRING_BOOT_REST}/profiles
curl -v ${SPRING_BOOT_REST}/app/name
curl -X POST \
  -H "Accept: application/json" \
  -H "Content-type: application/json" \
  -d @execute_request ${SPRING_BOOT_REST}/execute