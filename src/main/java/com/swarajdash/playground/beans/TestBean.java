package com.swarajdash.playground.beans;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestBean {

    public void process(Exchange exchange, String s) {
        log.info("Inside bean... {}", s);
    }
}
