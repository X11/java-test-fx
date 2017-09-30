package nl.tkeur;

public class LoginView implements ViewInterface {

    @Override
    public String getTitle() {
        return "Login";
    }

    @Override
    public String getFxmlPath() {
        return "views/scenes/login.fxml";
    }
}
