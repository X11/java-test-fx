package nl.tkeur.repositories;

import nl.tkeur.Database;
import nl.tkeur.models.User;

import java.sql.*;

public class UserRepository {

    private Database db;

    public UserRepository() {
        this.db = Database.getInstance();
    }

    public User getUserFromUsername(String username) {
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

        return null;
    }
}
