package com.rulyox.server.api;

import com.rulyox.data.User;
import com.rulyox.data.UserStore;
import com.rulyox.server.Response;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value="/user")
public class UserAPI {

    private static final UserStore userStore = UserStore.getInstance();

    /**
     * GET /user
     *
     * @return Text
     */
    @RequestMapping(method=GET)
    public String getUser() {

        return "User API";

    }

    /**
     * GET /user/id?id=1
     *
     * @param id User ID
     * @return User object
     */
    @RequestMapping(value="/id", method=GET)
    public ResponseEntity<Object> getUserId(
            @RequestParam(value="id") String id
    ) {

        User user = userStore.getUser(Integer.parseInt(id));

        ResponseEntity<Object> response;
        if(user != null) response = Response.user(user);
        else response = Response.errorNotFound();

        return response;

    }

    /**
     * GET /user/all
     *
     * @return List of all user objects
     */
    @RequestMapping(value="/all", method=GET)
    public ResponseEntity<Object> getUserAll() {

        List<User> userList = userStore.getAllUser();

        ResponseEntity<Object> response = Response.userList(userList);

        return response;

    }

    /**
     * POST /user/add
     *
     * @param body JSON { name: string, age: number }
     * @return JSON { id: number }
     */
    @RequestMapping(value="/add", method=POST)
    public ResponseEntity<Object> postUserAdd(
            @RequestBody HashMap<String, Object> body
    ) {

        // parse body
        String name = body.get("name").toString();
        int age = Integer.parseInt(body.get("age").toString());

        int id = userStore.addUser(name, age);

        // JSON response
        JSONObject json = new JSONObject();
        json.put("id", id);

        ResponseEntity<Object> response = Response.json(json);

        return response;

    }

    /**
     * GET /user/count
     *
     * @return JSON { count: number }
     */
    @RequestMapping(value="/count", method=GET)
    public ResponseEntity<Object> getUserCount() {

        int count = userStore.getCount();

        // JSON response
        JSONObject json = new JSONObject();
        json.put("count", count);

        ResponseEntity<Object> response = Response.json(json);

        return response;

    }

}
