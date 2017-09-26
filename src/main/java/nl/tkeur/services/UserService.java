package nl.tkeur.services;

import nl.tkeur.models.User;
import nl.tkeur.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    /**
     * @param username String
     * @param password String
     * @return boolean
     */
    public boolean authenticate(String username, String password) {
        User user = this.userRepository.getUserFromUsername(username);

        return BCrypt.checkpw(password, user.getPassword());
    }
}
