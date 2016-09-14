#!/bin/bash

set -e
set -E
set -x

./gradlew gatling

mkdir -p ../test_artifacts

cp -r build/gatling-results/groceryorder-* ../test_artifacts/grocery_order