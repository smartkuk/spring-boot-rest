#!/bin/bash

END_POINT=${END_POINT_URL}

if [ "$1" != "" ]; then
  END_POINT=$1
fi

if [ "${END_POINT}" == "" ]; then
  echo "END_POINT argument or END_POINT_URL env is required."
  exit 1;
fi

curl -v ${END_POINT}/host/info
curl -v ${END_POINT}/profiles
curl -v ${END_POINT}/app/name
curl -v ${END_POINT}/client/metrics
curl -X POST \
  -H "Accept: application/json" \
  -H "Content-type: application/json" \
  -d @execute_request ${END_POINT}/execute