docker run --name 'activemq' -it --rm \
       -p 8161:8161 \
       -p 61616:61616 \
       -p 61613:61613 \
       webcenter/activemq:5.14.3
