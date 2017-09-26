package nl.tkeur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL resource = getClass().getClassLoader().getResource("views/scenes/login.fxml");
        Parent root = null;
        if (resource != null) {
            root = FXMLLoader.load(resource);
        }
        primaryStage.setTitle("User login");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
