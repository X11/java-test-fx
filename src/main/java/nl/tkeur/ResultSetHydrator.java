package nl.tkeur;

import java.sql.ResultSet;

public interface ResultSetHydrator {

    boolean hydrate(ResultSet rs);
}
