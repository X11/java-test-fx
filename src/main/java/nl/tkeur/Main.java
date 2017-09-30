package nl.tkeur;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup Dependency Injection
        InstanceProvider.setup();

        // Setup the router
        Router router = InstanceProvider.getInstance(Router.class);
        router.setStage(primaryStage);

        // Add views
        router.addView("login", new LoginView());
        router.addView("overview", new OverviewView());

        // Set the default view
        router.setView("login");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
