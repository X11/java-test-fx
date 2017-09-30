package nl.tkeur;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username) {
        super(username);
    }
}
