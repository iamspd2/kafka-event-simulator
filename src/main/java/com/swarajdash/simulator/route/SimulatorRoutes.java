package com.swarajdash.simulator.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
class SimulatorRoutes extends RouteBuilder {

  @Override
  public void configure() {

    restConfiguration().component("servlet");

    from("direct:publishEventFlow")
        .log("Inside Camel Route to publish an event...")
        .toD("kafka:${exchangeProperty.TOPIC}?brokers=${exchangeProperty.broker}")
        .setBody(constant("success"))
        .log("Event published successfully! Exiting Route...");
  }
}
