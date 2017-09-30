package nl.tkeur;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class DefaultLayout extends VBox {

    public DefaultLayout() {
        URL url = getClass().getClassLoader().getResource("views/layouts/default.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setControllerFactory(InstanceProvider::getInstance);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
