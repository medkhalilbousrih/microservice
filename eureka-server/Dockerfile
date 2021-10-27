FROM java:8
EXPOSE 8761
ADD /target/eureka-server-1.jar eureka-micro.jar
ENTRYPOINT ["java","-jar","eureka-micro.jar"]