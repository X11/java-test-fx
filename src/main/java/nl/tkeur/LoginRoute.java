package nl.tkeur;

public class LoginRoute implements Router.Route {
    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getTitle() {
        return "Login";
    }

    @Override
    public String getFxmlPath() {
        return "views/scenes/login.fxml";
    }
}
