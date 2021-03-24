package com.rulyox.server.api;

import com.rulyox.data.Post;
import com.rulyox.data.PostStore;
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
@RequestMapping(value="/post")
public class PostAPI {

    private static final PostStore postStore = PostStore.getInstance();

    /**
     * GET /post
     *
     * @return Text
     */
    @RequestMapping(method=GET)
    public String getPost() {

        return "Post API";

    }

    /**
     * GET /post/id?id=1
     *
     * @param id Post ID
     * @return Post object
     */
    @RequestMapping(value="/id", method=GET)
    public ResponseEntity<Object> getPostId(
            @RequestParam(value="id") String id
    ) {

        Post post = postStore.getPost(Integer.parseInt(id));

        ResponseEntity<Object> response;
        if(post != null) response = Response.post(post);
        else response = Response.errorNotFound();

        return response;

    }

    /**
     * GET /post/all
     *
     * @return List of all post objects
     */
    @RequestMapping(value="/all", method=GET)
    public ResponseEntity<Object> getPostAll() {

        List<Post> postList = postStore.getAllPost();

        ResponseEntity<Object> response = Response.postList(postList);

        return response;

    }

    /**
     * POST /post/add
     *
     * @param body JSON { user: number, text: string }
     * @return JSON { id: number }
     */
    @RequestMapping(value="/add", method=POST)
    public ResponseEntity<Object> postPostAdd(
            @RequestBody HashMap<String, Object> body
    ) {

        // parse body
        int user = Integer.parseInt(body.get("user").toString());
        String text = body.get("text").toString();

        int id = postStore.addPost(user, text);

        // JSON response
        JSONObject json = new JSONObject();
        json.put("id", id);

        ResponseEntity<Object> response = Response.json(json);

        return response;

    }

    /**
     * GET /post/count
     *
     * @return JSON { count: number }
     */
    @RequestMapping(value="/count", method=GET)
    public ResponseEntity<Object> getPostCount() {

        int count = postStore.getCount();

        // JSON response
        JSONObject json = new JSONObject();
        json.put("count", count);

        ResponseEntity<Object> response = Response.json(json);

        return response;

    }

}
