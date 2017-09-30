package nl.tkeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private Database db;

    public UserRepository(Database db) {
        this.db = db;
    }

    User getUserFromUsername(String username) throws UserNotFoundException {
        Connection conn = this.db.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * from users where username = ? LIMIT 1");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                User user = new User();
                if (user.hydrate(rs)) {
                    return user;
                }
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new UserNotFoundException(username);
    }
}
