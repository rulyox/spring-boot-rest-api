package com.rulyox.data;

import java.util.ArrayList;
import java.util.List;

public class UserStore {

    // singleton
    private UserStore() {

    }

    private static class UniqueInstanceClass {
        private static final UserStore uniqueInstance = new UserStore();
    }

    public static UserStore getInstance() {
        return UniqueInstanceClass.uniqueInstance;
    }

    private final ArrayList<User> userList = new ArrayList<>();
    private int countId = 0;

    public int getCount() {

        return userList.size();

    }

    public User getUser(int id) {

        for(User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }

        return null;

    }

    public List<User> getAllUser() {

        return new ArrayList<>(userList);

    }

    public int addUser(String name, int age) {

        countId += 1;
        int id = countId;

        User user = new User(id, name, age);

        userList.add(user);

        return id;

    }

}
