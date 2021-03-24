package com.rulyox.server;

import com.rulyox.data.User;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserApiTemplate extends ApiTemplate {

    public UserApiTemplate(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public JSONObject addUser(String name, int age) {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);

        HttpEntity<Object> httpEntity = jsonToHttpEntity(json);

        ResponseEntity<Map> response = restTemplate.postForEntity(url + "/user/add", httpEntity, Map.class);

        // parse response
        Map map = response.getBody();
        JSONObject responseJson = new JSONObject(map);

        return responseJson;

    }

    public User getUser(int id) {

        ResponseEntity<User> response = restTemplate.getForEntity(url + "/user/id?id={id}", User.class, id);

        // parse response
        User user = response.getBody();

        return user;

    }

    public List<User> getAllUser() {

        ResponseEntity<List> response = restTemplate.getForEntity(url + "/user/all", List.class);

        // parse response
        List<User> userList = response.getBody();

        return userList;

    }

    public JSONObject getUserCount() {

        ResponseEntity<Map> response = restTemplate.getForEntity(url + "/user/count", Map.class);

        // parse response
        Map map = response.getBody();
        JSONObject json = new JSONObject(map);

        return json;

    }

}
