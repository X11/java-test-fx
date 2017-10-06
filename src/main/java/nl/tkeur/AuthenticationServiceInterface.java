package nl.tkeur;

public interface AuthenticationServiceInterface {

    /**
     * Authenticate a username and password against an user in the database. Returns an boolean if the user is
     * successfully authenticated
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * Remove the authenticated user from this session
     *
     * @return
     */
    boolean logout();

    /**
     * Get the authenticated user.
     *
     * @return
     */
    User getAuthenticatedUser();

    /**
     * Check if an user is authenticated in the session.
     * @return
     */
    boolean isAuthenticated();
}
