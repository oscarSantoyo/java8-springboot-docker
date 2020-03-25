mvn clean package &&
    docker build -t orders-app . &&
    docker run --rm -it -p 8070:80 orders-app
