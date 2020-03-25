FROM openjdk:8

COPY ./target/orders-1.0.jar /usr/src/orders/
WORKDIR /usr/src/orders/

CMD ["java", "-jar","-Dspring.profiles.active=prod", "orders-1.0.jar"]

EXPOSE 80 