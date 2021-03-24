package com.rulyox.server;

import com.rulyox.data.Post;
import com.rulyox.data.User;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class Response {

    public static ResponseEntity<Object> json(JSONObject json) {

        return new ResponseEntity<>(json.toMap(), OK);

    }

    public static ResponseEntity<Object> user(User user) {

        return new ResponseEntity<>(user, OK);

    }

    public static ResponseEntity<Object> userList(List<User> list) {

        return new ResponseEntity<>(list, OK);

    }

    public static ResponseEntity<Object> post(Post post) {

        return new ResponseEntity<>(post, OK);

    }

    public static ResponseEntity<Object> postList(List<Post> list) {

        return new ResponseEntity<>(list, OK);

    }

    public static ResponseEntity<Object> errorNotFound() {

        return new ResponseEntity<>(null, NOT_FOUND);

    }

}
