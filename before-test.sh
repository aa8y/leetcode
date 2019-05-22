#!/bin/bash

DOCKER_REPO=aa8y/leetcode
SUPPORTED_LANGUAGES=(java node.js scala)

for CONTEXT in "${SUPPORTED_LANGUAGES[@]}"
do
    if [[ -f $CONTEXT/Dockerfile ]]; then
        docker build -t $DOCKER_REPO:$CONTEXT $CONTEXT
    fi
done
