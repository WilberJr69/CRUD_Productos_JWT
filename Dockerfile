FROM openjdk:21-jdk

WORKDIR /app

COPY build/libs/gestion_productos-0.0.1-SNAPSHOT.jar /app/gestion_productos.jar

EXPOSE 8080

CMD ["java", "-jar", "gestion_productos.jar"]