FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tp1-spring-boot-1.0.jar tp1-spring-boot-1.0.jar 
ENTRYPOINT ["java","-jar","/tp1-spring-boot-1.0.jar"]
