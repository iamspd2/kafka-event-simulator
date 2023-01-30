package com.swarajdash.simulator.controller;

import com.swarajdash.simulator.model.EventDetailsForm;
import com.swarajdash.simulator.service.SimulatorPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class HomepageController {

    @Autowired
    private SimulatorPublisherService simulatorPublisherService;

    @GetMapping("/")
    public String getHomePage(@ModelAttribute("eventDetails") EventDetailsForm newMessage, Model model) {
        return "home";
    }

    @PostMapping("/publish")
    public String postEvent(@ModelAttribute("eventDetails") EventDetailsForm eventDetailsForm, Model model) {
        log.info("Form received from webpage!");
        String result = simulatorPublisherService.publishMessage(eventDetailsForm);
        model.addAttribute("publishResult", result);
        return "home";
    }

}
