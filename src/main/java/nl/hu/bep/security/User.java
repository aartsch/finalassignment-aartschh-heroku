package nl.hu.bep.security;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Principal, Serializable {
    private String username;
    private String password;
    private String role;

    private static List<User> users = new ArrayList<>();

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static void initializeUsers() {
        users.add(new User("aart", "wachtwoord", "user"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public static List<User> getAllUsers() {
        return users;
    }
}
