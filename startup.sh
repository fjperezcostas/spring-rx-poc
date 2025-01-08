#!/bin/bash

get_module_version() {
    mvn -f "$1" org.apache.maven.plugins:maven-help-plugin:3.5.1:evaluate -Dexpression=project.version -q -DforceStdout
}

cleanup() {
  echo "Stopping all processes..."
  for pid in "${PID[@]}"; do
    kill "$pid" 2>/dev/null
  done
  wait 2>/dev/null
  echo "All processes stopped."
  exit 0
}

MODULES=("backend-service" "sync-proxy" "rx-proxy")
PID=()

trap cleanup SIGINT
mvn clean package
mkdir -p "$(pwd)/.logs"
for module_name in "${MODULES[@]}"; do
  module_version="$(get_module_version "${module_name}")"
  echo "Starting service ${module_name}..."
  java -jar "$(pwd)/${module_name}/target/${module_name}-${module_version}.jar" > "$(pwd)/.logs/${module_name}.log" 2>&1 &
  PID+=($!)
  echo "Service ${module_name} started with PID $!..."
done
echo "Press ctrl+c to stop all processes..."
wait
