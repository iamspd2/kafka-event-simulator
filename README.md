# Kafka Event Simulator

This simple Spring Boot application lets you publish Kafka events seamlessly from your browser
with minimal configuration & dependencies.

## How To Install

Open a terminal and execute the following commands:

```shell
# clone the repository
$ git clone https://github.com/iamspd2/kafka-event-simulator.git

# go inside the directory
$ cd kafka-event-simulator

# install the application
$ mvn clean install

# run the application
$ java -jar target/kafka-event-simulator-1.0-SNAPSHOT.jar
```

## How To Use

1. Go to [`localhost:4589`](http://localhost:4589) in your browser
2. Enter the payload & topic name in the text input fields
3. Click on `Submit`
4. The app will take care of creating the topic dynamically & publish the Kafka event

### The `application.properties` file

This app requires minimal configuration. Feel free to tweak the following properties:
- `server.port`: The port number on which the application would run
- `kafkaProp.broker.url`: Kafka Broker URL. If not present, default value of `localhost:9092` would be taken

### Tech Used
- Spring Boot
- Thymeleaf
- Apache Camel

### Contributors
Swaraj P. Dash

_Feel free to fork this repo & make your additions. Will merge suitable PRs._