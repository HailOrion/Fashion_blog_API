FROM openjdk:18.0
EXPOSE 8000
ADD target/demo-0.0.1-SNAPSHOT.jar fashion_blog_repo.jar
ENTRYPOINT ["java", "-jar", "fashion_blog_repo.jar"]
