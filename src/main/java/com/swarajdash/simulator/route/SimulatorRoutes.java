package com.swarajdash.simulator.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class SimulatorRoutes extends RouteBuilder {
    @Override
    public void configure() {
        CamelContext context = new DefaultCamelContext();

        restConfiguration().component("servlet");

        rest("").get("testapp")
                        .to("direct:publishEventFlow");

        from("direct:publishEventFlow")
                .log("Inside Camel Route to publish an event...")
                .toD("kafka:${exchangeProperty.TOPIC}?brokers={{kafkaProp.broker.url:localhost:9092}}")
                .setBody(constant("success"))
                .log("Event published successfully! Exiting Route...");
    }
}
