package letmein;

public class User {
    private final String name;
    private final String passwordHash;

    public User(String name, String password) {
        this.name = name;
        this.passwordHash = PasswordHash.hashPassword(password);

    }

    public String getName() {
        return name;
    }
    
    public boolean checkPassword(String passwordToTest) {
        return this.passwordHash.equals(PasswordHash.hashPassword(passwordToTest));
    }   
}
