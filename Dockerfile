FROM java:8-jdk-alpine

run mkdir -p usr/app/src

COPY ./target/protobuf-0.0.1-SNAPSHOT.jar /usr/app/src

WORKDIR /usr/app/src

RUN sh -c 'touch protobuf-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","protobuf-0.0.1-SNAPSHOT.jar"]  
