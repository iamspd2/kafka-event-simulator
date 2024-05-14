package com.swarajdash.simulator;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaSimulatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaSimulatorApplication.class, args);
  }

  @Bean
  ServletRegistrationBean servletRegistrationBean() {
    ServletRegistrationBean servlet = new ServletRegistrationBean
        (new CamelHttpTransportServlet(), "/camel/*");
    servlet.setName("CamelServlet");
    return servlet;
  }
}
