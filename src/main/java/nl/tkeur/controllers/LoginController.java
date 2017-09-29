package nl.tkeur.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.tkeur.services.UserService;
import nl.tkeur.Router;

import javax.inject.Inject;

public class LoginController {

    private final UserService userService;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Router router;

    @Inject
    public LoginController(Router router, UserService userService) {
        this.router = router;
        this.userService = userService;
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (! this.userService.authenticate(username, password)) {
            errorLabel.setText("Username and password combination do not match!");
            return;
        }

        System.out.println("Succesfully authenticated");
        this.router.setView("overview");
    }
}