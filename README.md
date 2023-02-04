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

1. Go to [`localhost:4589`](http://localhost:4589) in your browser.
2. Enter the payload & topic name in the text input fields.
3. Choose the broker where you want to publish to. You can define a list of environments as explained below.
4. Click on `Submit`.
5. The app will take care of creating the topic dynamically & publish your desired Kafka event.

### The `application.yml` file

This app requires minimal configuration. Feel free to tweak the following properties:
- `server.port`: The port number on which the application would run.
- `props.brokers`: Your list of Kafka Broker URLs, from which you can choose from in the UI & publish to multiple environments at will.

### Tech Used
- Spring Boot
- Thymeleaf
- Apache Camel

### Contributors
Swaraj P. Dash

_Feel free to fork this repo & make your additions. Will merge suitable PRs._