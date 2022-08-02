FROM openjdk:18.0
EXPOSE 8000
ADD target/fashion_blog_repo.jar fashion_blog_repo.jar
ENTRYPOINT ["java", "-jar", "fashion_blog_repo.jar"]
