package nl.tkeur;

import java.sql.Connection;

public interface DatabaseInterface {

    /**
     * Return an database connection to use
     *
     * @return
     */
    Connection getConnection();
}
