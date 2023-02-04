package com.swarajdash.simulator.controller;

import com.swarajdash.simulator.model.Broker;
import com.swarajdash.simulator.model.EventDetailsForm;
import com.swarajdash.simulator.service.SimulatorPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@ConfigurationProperties(prefix = "props")
@Controller
public class HomepageController {

    @Autowired
    private SimulatorPublisherService simulatorPublisherService;

    private HashMap<String, String> brokers;

    @GetMapping("/")
    public String getHomePage(@ModelAttribute("eventDetails") EventDetailsForm newMessage, Model model) {
        model.addAttribute("brokerList", fetchBrokerList());
        return "home";
    }

    @PostMapping("/publish")
    public String postEvent(@ModelAttribute("eventDetails") EventDetailsForm eventDetailsForm, Model model) {
        log.info("Form received from webpage!");
        String result = simulatorPublisherService.publishMessage(eventDetailsForm);
        model.addAttribute("publishResult", result);
        model.addAttribute("brokerList", fetchBrokerList());
        return "home";
    }

    private List<Broker> fetchBrokerList() {
        List<Broker> brokerList = new ArrayList<>();
        for (String key : brokers.keySet()) {
            Broker broker = new Broker(key, brokers.get(key));
            brokerList.add(broker);
        }
        return brokerList;
    }

    /* getters & setters */
    public HashMap<String, String> getBrokers() {
        return brokers;
    }

    public void setBrokers(HashMap<String, String> brokers) {
        this.brokers = brokers;
    }

}
