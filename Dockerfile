FROM ubuntu:20.04

RUN apt-get update && apt-get install -y --no-install-recommends \
    maven \
    openjdk-11-jdk \
 && rm -rf /var/lib/apt/lists/*
