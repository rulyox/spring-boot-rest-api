package com.rulyox.server;

import com.rulyox.data.Post;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PostApiTemplate template;

    @BeforeEach
    public void beforeEach() {

        template.setPort(port);

    }

    @Test
    public void addPost() {

        // first
        JSONObject json1 = this.template.addPost(1, "Hello World!");

        then(json1.get("id"))
                .isEqualTo(1);

        // second
        JSONObject json2 = this.template.addPost(2, "Add post test");

        then(json2.get("id"))
                .isEqualTo(2);

    }

    @Test
    public void getPost() {

        // first
        Post post1 = this.template.getPost(1);

        then(post1.getId())
                .isEqualTo(1);

        then(post1.getUser())
                .isEqualTo(1);

        then(post1.getText())
                .isEqualTo("Hello World!");

        // second
        Post post2 = this.template.getPost(2);

        then(post2.getId())
                .isEqualTo(2);

        then(post2.getUser())
                .isEqualTo(2);

        then(post2.getText())
                .isEqualTo("Add post test");

    }

    @Test
    public void getAllPost() {

        List<Post> postList = this.template.getAllPost();

        then(postList.size())
                .isEqualTo(2);

    }

    @Test
    public void getPostCount() {

        JSONObject json = this.template.getPostCount();

        then(json.get("count"))
                .isEqualTo(2);

    }

}
