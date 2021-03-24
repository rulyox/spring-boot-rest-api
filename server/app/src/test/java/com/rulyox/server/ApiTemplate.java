package com.rulyox.server;

import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiTemplate {

    protected final RestTemplate restTemplate;
    protected String url = "http://localhost";

    public ApiTemplate(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public void setPort(int port) {

        url = "http://localhost:" + port;

    }

    protected HttpEntity<Object> jsonToHttpEntity(JSONObject json) {

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Content-Type", "application/json");

        return new HttpEntity<>(json.toString(), header);

    }

}
