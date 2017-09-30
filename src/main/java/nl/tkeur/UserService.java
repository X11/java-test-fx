package nl.tkeur;

import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Singleton;

@Singleton
class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param username String
     * @param password String
     * @return boolean
     */
    boolean authenticate(String username, String password) {
        User user = this.userRepository.getUserFromUsername(username);

        return BCrypt.checkpw(password, user.getPassword());

    }
}
