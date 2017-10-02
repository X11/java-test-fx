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
        router.addView(InstanceProvider.getInstance(LoginView.class));
        router.addView(InstanceProvider.getInstance(OverviewView.class));

        // Set the default view
        try {
            router.setView("login");
        } catch (RouterException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
