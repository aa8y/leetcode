#!/bin/bash

DOCKER_REPO=aa8y/leetcode

declare -A TEST_CMD=([java]=check [node.js]=test [scala]=test)

for TAG in "${!TEST_CMD[@]}"
do
    echo "Running '$TAG' tests"
    docker run --rm -it $DOCKER_REPO:$TAG ${TEST_CMD[$TAG]}
done
