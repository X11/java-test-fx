package nl.tkeur.models;

import nl.tkeur.ResultSetHydrator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements ResultSetHydrator {

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
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
