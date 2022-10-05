FROM openjdk:8
EXPOSE 8080
ADD target/tp1-spring-boot.jar tp1-spring-boot.jar 
ENTRYPOINT ["java","-jar","/tp1-spring-boot.jar"]