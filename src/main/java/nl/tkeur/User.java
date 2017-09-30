package nl.tkeur;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements ResultSetHydrator {

    private int id;
    private String username;
    private String password;

    int getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public boolean hydrate(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.username = rs.getString("username");
            this.password = rs.getString("password");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
