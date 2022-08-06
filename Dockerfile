FROM openjdk:18.0.1
EXPOSE 8080
ADD target/fashionblog.jar fashionblog.jar
ENTRYPOINT ["java", "-jar", "fashionblog.jar"]
