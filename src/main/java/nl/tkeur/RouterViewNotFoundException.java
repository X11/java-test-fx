package nl.tkeur;

public class RouterViewNotFoundException extends Exception {
    public RouterViewNotFoundException(String name) {
        super(name);
    }
}
