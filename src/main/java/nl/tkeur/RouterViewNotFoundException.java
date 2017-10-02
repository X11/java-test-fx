package nl.tkeur;

public class RouterViewNotFoundException extends RouterException {
    public RouterViewNotFoundException(String name) {
        super(name);
    }
}
