#!/bin/sh
echo "haproxy deve estar instalado, apt-get install haproxy"
haproxy -f haproxy-sticky.conf && echo "haproxy running ... [sticky]" 

