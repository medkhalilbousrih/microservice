FROM java:8
EXPOSE 8888
ADD /target/ConfigServer-1.jar config-micro.jar
ENTRYPOINT ["java","-jar","config-micro.jar"]