FROM java:8
EXPOSE 8762
ADD /target/Zuul-Gateway-1.jar zuul-micro.jar
ENTRYPOINT ["java","-jar","zuul-micro.jar"]