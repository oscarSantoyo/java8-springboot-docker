mvn clean package &&
    docker build -t products-app . &&
    docker run --rm -it -p 8090:80 products-app
