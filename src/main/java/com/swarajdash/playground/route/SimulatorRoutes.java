package com.swarajdash.playground.route;

import org.apache.camel.BeanScope;
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

        rest("").get("test")
                        .to("direct:publishEventFlow");

        from("direct:publishEventFlow")
                .log("Inside flow")
                .setProperty("abc",constant("hello world"))
                .bean("testBean", "process(*,${exchangeProperty.abc})")
                .log("exiting route")
                .end();
    }
}
