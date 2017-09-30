package nl.tkeur;

import java.sql.ResultSet;

interface ResultSetHydrator {

    boolean hydrate(ResultSet rs);
}
