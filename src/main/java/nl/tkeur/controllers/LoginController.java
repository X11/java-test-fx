package nl.tkeur.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import nl.tkeur.services.UserService;

public class LoginController {

    private final UserService userService;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public LoginController() {
        this.userService = new UserService();
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (! this.userService.authenticate(username, password)) {
            errorLabel.setText("Username and password combination do not match!");
            return;
        }

        errorLabel.setText("");
        System.out.println("Succesfully authenticated");
    }
}
