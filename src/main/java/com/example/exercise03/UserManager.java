package main.java.com.example.exercise03;

import java.util.LinkedList;
import java.util.List;

public class UserManager {
    private final List<User> users = new LinkedList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public boolean deleteUserByEmail(String email) {
        return users.removeIf(user -> user.email().equalsIgnoreCase(email));
    }

    public List<User> getAllUsers() {
        return List.copyOf(users);
    }
}
