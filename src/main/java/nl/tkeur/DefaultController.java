package nl.tkeur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

public class DefaultController {

    private AuthenticationService authenticationService;
    private Router router;

    @Inject
    public DefaultController(AuthenticationService authenticationService, Router router) {
        this.authenticationService = authenticationService;
        this.router = router;
    }

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        String text = String.format("Welcome %s!", this.authenticationService.getAuthenticatedUser().getUsername());
        welcomeLabel.setText(text);
    }

    @FXML
    public void handleLogoutButtonAction(ActionEvent actionEvent) {
        this.authenticationService.logout();

        try {
            this.router.setRoute("login");
        } catch (RouterException e) {
            e.printStackTrace();
        }
    }
}
