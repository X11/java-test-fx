package nl.tkeur;

import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Singleton;

@Singleton
public class AuthenticationService {

    private UserRepository userRepository;
    private User authenticatedUser;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.setAuthenticatedUser(null);
    }

    /**
     * Authenticate a user from a username and password combination
     *
     * @param username String
     * @param password String
     *
     * @return boolean
     */
    public boolean login(String username, String password) {
        try {
            User user = this.userRepository.getUserFromUsername(username);
            if (BCrypt.checkpw(password, user.getPassword())) {
                this.setAuthenticatedUser(user);
                return true;
            }
        } catch (UserNotFoundException ignored) {
            // Do nothing and fall through
        }

        return false;
    }

    public boolean logout() {
        this.setAuthenticatedUser(null);
        return true;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    private void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public boolean isAuthenticated() {
        return this.getAuthenticatedUser() != null;
    }
}
