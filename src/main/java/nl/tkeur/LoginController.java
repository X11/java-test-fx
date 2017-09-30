package nl.tkeur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class LoginController {

    private final AuthenticationService authenticationService;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Router router;

    @Inject
    public LoginController(Router router, AuthenticationService authenticationService) {
        this.router = router;
        this.authenticationService = authenticationService;
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (! this.authenticationService.login(username, password)) {
            errorLabel.setText("Username and password combination do not match!");
            return;
        }

        System.out.println("Succesfully authenticated");

        try {
            this.router.setView("default/overview");
        } catch (RouterViewNotFoundException e) {
            e.printStackTrace();
        }
    }
}
