#!/bin/bash

curl -H 'Content-Type: application/json' -X POST localhost:8080/mail -d '{ "from": "test@mail.com", "subject": "Subject", "message": "My test message"  }'