# Kafka Event Simulator

This simple Spring Boot application lets you publish Kafka events seamlessly from your browser
with minimal configuration & dependencies.

## How To Use

1. Clone this repository & open in an IDE of your choice
2. Start the application
3. Open [`localhost:4589`](http://localhost:4589) in your browser
4. Enter the payload & topic name in the text inputs
5. Click on `Submit`
6. The app will take care of publishing the Kafka event

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