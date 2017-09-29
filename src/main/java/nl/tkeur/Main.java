package nl.tkeur;

import eu.lestard.easydi.EasyDI;
import javafx.application.Application;
import javafx.stage.Stage;
import nl.tkeur.views.LoginView;
import nl.tkeur.views.OverviewView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setup Depedency Injection
        AppServiceProvider.setup();

        // Setup the router
        Router router = AppServiceProvider.getInstance(Router.class);
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
