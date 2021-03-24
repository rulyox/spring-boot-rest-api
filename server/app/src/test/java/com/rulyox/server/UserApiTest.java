package com.rulyox.server;

import com.rulyox.data.User;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserApiTemplate template;

    @BeforeEach
    public void beforeEach() {

        template.setPort(port);

    }

    @Test
    public void addUser() {

        // first
        JSONObject json1 = this.template.addUser("Alice", 20);

        then(json1.get("id"))
                .isEqualTo(1);

        // second
        JSONObject json2 = this.template.addUser("Bob", 25);

        then(json2.get("id"))
                .isEqualTo(2);

    }

    @Test
    public void getUser() {

        // first
        User user1 = this.template.getUser(1);

        then(user1.getId())
                .isEqualTo(1);

        then(user1.getName())
                .isEqualTo("Alice");

        then(user1.getAge())
                .isEqualTo(20);

        // second
        User user2 = this.template.getUser(2);

        then(user2.getId())
                .isEqualTo(2);

        then(user2.getName())
                .isEqualTo("Bob");

        then(user2.getAge())
                .isEqualTo(25);

    }

    @Test
    public void getAllUser() {

        List<User> userList = this.template.getAllUser();

        then(userList.size())
                .isEqualTo(2);

    }

    @Test
    public void getUserCount() {

        JSONObject json = this.template.getUserCount();

        then(json.get("count"))
                .isEqualTo(2);

    }

}
