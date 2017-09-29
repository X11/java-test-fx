package nl.tkeur;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Singleton
public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost/testfx";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "secret";

    private Connection connection;

    /**
     * Create a new Database instance
     */
    Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }
}
