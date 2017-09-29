package nl.tkeur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.tkeur.views.ViewInterface;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

@Singleton
public class Router {
    private Stage stage;
    private HashMap<String, ViewInterface> views;
    private InstanceProvider instanceProvider;

    public Router(InstanceProvider instanceProvider) {
        this.instanceProvider = instanceProvider;
        this.views = new HashMap<>();
    }

    /**
     * Add a new view to the router
     *
     * @param name Name of the view
     * @param view The view class
     */
    public void addView(String name, ViewInterface view) {
        this.views.put(name, view);
    }

    /**
     * Set the root stage for router
     *
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Set the current view on the stage
     *
     * @param name The name of the view to load
     */
    public void setView(String name) {
        ViewInterface view = this.views.get(name);
        Parent root = this.getParentRoot(view.getFxmlPath());
        this.stage.setTitle(view.getTitle());
        this.stage.setScene(new Scene(root, 800, 600));
        this.stage.show();
    }

    /**
     * Load the root from a fxml resource
     *
     * @param path The filepath
     *
     * @return The parent
     */
    private Parent getParentRoot(String path) {
        try {

            URL url = getClass().getClassLoader().getResource(path);

            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            loader.setControllerFactory(controllerClass -> this.instanceProvider.getInstance(controllerClass));

            return (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
