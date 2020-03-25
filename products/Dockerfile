FROM openjdk:8

COPY ./target/products-1.0.jar /usr/src/products/
WORKDIR /usr/src/products/

CMD ["java", "-jar","-Dspring.profiles.active=prod", "products-1.0.jar"]

EXPOSE 80 