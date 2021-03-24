package com.rulyox.data;

import java.util.ArrayList;
import java.util.List;

public class PostStore {

    // singleton
    private PostStore() {

    }

    private static class UniqueInstanceClass {
        private static final PostStore uniqueInstance = new PostStore();
    }

    public static PostStore getInstance() {
        return PostStore.UniqueInstanceClass.uniqueInstance;
    }

    private final ArrayList<Post> postList = new ArrayList<>();
    private int countId = 0;

    public int getCount() {

        return postList.size();

    }

    public Post getPost(int id) {

        for(Post post : postList) {
            if(post.getId() == id) {
                return post;
            }
        }

        return null;

    }

    public List<Post> getAllPost() {

        return new ArrayList<>(postList);

    }

    public int addPost(int user, String text) {

        countId += 1;
        int id = countId;

        Post post = new Post(id, user, text);

        postList.add(post);

        return id;

    }

}
