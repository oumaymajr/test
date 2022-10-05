FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tp1-spring-boot.jar tp1-spring-boot.jar 
ENTRYPOINT ["java","-jar","/tp1-spring-boot.jar"]