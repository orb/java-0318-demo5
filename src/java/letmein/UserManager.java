package letmein;

import java.util.ArrayList;
import java.util.Optional;

public class UserManager {

    private ArrayList<User> users = new ArrayList<>();

    private static boolean nameAndPasswordMatches(User user, String name, String password) {
        return user.getName().equals(name) && user.checkPassword(password);
    }

    public User findUserIfValid(String name, String password) {
        if (name != null && password != null) {
            for (User user : users) {
                if (nameAndPasswordMatches(user, name, password)) {
                    return user;
                }
            }
        }

        return null;
    }

    // lambda/stream variant
    // uses optional instead of returning null
    public Optional<User> findUserIfValid2(String name, String password) {
        if (name == null || password == null) {
            return Optional.empty();
        } else {
            return users
                    .stream()
                    .filter(user -> nameAndPasswordMatches(user, name, password))
                    .findFirst();
        } 
    }

    void addUser(User newUser) {
        for (User user : users) {
            if (user.getName().equals(newUser.getName())) {
                throw new IllegalArgumentException("duplicate user");
            }
        }
        users.add(newUser);
    }

}
