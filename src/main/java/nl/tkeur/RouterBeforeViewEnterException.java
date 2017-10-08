package nl.tkeur;

public class RouterBeforeViewEnterException extends RouterException {
    public RouterBeforeViewEnterException(Router.Route view) {
        super(String.format("Router: BeforeViewEnter returned false for view %s", view.getName()));
    }
}
