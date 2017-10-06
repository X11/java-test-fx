package nl.tkeur;

public interface UserRepositoryInterface {

    /**
     * Retrieve a user from the database by its username
     *
     * @param username The users username
     * @return
     * @throws UserNotFoundException
     */
    User getUserFromUsername(String username) throws UserNotFoundException;
}
