#!/usr/bin/env bash

# jar包名称
PROJECT_VERSION=`sed '/^application.version=/!d;s/.*=//' conf/application.properties`
SERVER_NAME=`sed '/^spring.application.name=/!d;s/.*=//' conf/application.properties`

SERVER_JAR="$SERVER_NAME-$PROJECT_VERSION.jar"

# 停止项目
echo -n "Stopping server ..."
    PID=$(ps -ef | grep $SERVER_JAR | grep -v grep |awk '{print $2}')
if [ -z "$PID" ]; then
  echo Application is already stopped
else
  echo kill $PID
  kill -9 $PID
fi
exit 0