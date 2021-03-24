package com.rulyox.server.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value="/")
public class MainAPI {

    @Value("${config.message}")
    String configMessage;

    /**
     * GET /
     *
     * @return Text
     */
    @RequestMapping(method=GET)
    public String get() {

        return "Spring Boot REST API Server" + "<br>" + configMessage;

    }

}
