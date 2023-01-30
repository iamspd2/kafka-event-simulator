package com.swarajdash.simulator.service;

import com.swarajdash.simulator.model.EventDetailsForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimulatorPublisherService {

    @Autowired
    CamelContext camelContext;

    public String publishMessage(EventDetailsForm form) {
        log.info("Inside publishMessage service method");
        try (FluentProducerTemplate template = camelContext.createFluentProducerTemplate()) {
            return template
                    .withProcessor(
                            exchange -> {
                                exchange.setProperty("TOPIC", form.getTopic());
                                exchange.getIn().setBody(form.getPayload());
                            })
                    .to("direct:publishEventFlow").request(String.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

}
