package nl.tkeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class UserRepository {

    private Database db;

    public UserRepository(Database db) {
        this.db = db;
    }

    User getUserFromUsername(String username) {
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

        // TODO: Throw error when user is not found
        return null;
    }
}
