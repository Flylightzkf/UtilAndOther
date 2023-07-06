#!/usr/bin/env bash

# 指定堆内存
HEAP_XMX="2G"
HEAP_XMN="512m"

echo "heap $JAVA_HEAP_XMX"

if [ -n "$JAVA_HEAP_XMX" ]; then
    HEAP_SIZE = "$JAVA_HEAP_XMX"
fi

if [ -n "$JAVA_HEAP_XMN"]; then
    HEAP_XMN = "$JAVA_HEAP_XMN"
fi

echo "堆内存大小: $HEAP_XMX"
echo "堆内存年轻代大小: $HEAP_XMN"
