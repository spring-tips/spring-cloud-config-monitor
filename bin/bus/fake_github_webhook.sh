#!/usr/bin/env bash


wh_payload=$(cat fake_github_webhook_payload.txt)
curl -X POST -H"X-Github-Event: push" -d '$wh_payload' http://localhost:8888/monitor?path=client.properties