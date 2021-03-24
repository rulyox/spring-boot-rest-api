package com.rulyox.server;

import com.rulyox.data.Post;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostApiTemplate extends ApiTemplate {

    public PostApiTemplate(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public JSONObject addPost(int user, String text) {

        JSONObject json = new JSONObject();
        json.put("user", user);
        json.put("text", text);

        HttpEntity<Object> httpEntity = jsonToHttpEntity(json);

        ResponseEntity<Map> response = restTemplate.postForEntity(url + "/post/add", httpEntity, Map.class);

        // parse response
        Map map = response.getBody();
        JSONObject responseJson = new JSONObject(map);

        return responseJson;

    }

    public Post getPost(int id) {

        ResponseEntity<Post> response = restTemplate.getForEntity(url + "/post/id?id={id}", Post.class, id);

        // parse response
        Post post = response.getBody();

        return post;

    }

    public List<Post> getAllPost() {

        ResponseEntity<List> response = restTemplate.getForEntity(url + "/post/all", List.class);

        // parse response
        List<Post> postList = response.getBody();

        return postList;

    }

    public JSONObject getPostCount() {

        ResponseEntity<Map> response = restTemplate.getForEntity(url + "/post/count", Map.class);

        // parse response
        Map map = response.getBody();
        JSONObject json = new JSONObject(map);

        return json;

    }

}
