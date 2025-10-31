FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/laptopshop-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
