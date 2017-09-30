package nl.tkeur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

@Singleton
public class Router {
    private Stage stage;
    private HashMap<String, ViewInterface> views;

    public Router() {
        this.views = new HashMap<>();
    }

    /**
     * Add a new view to the router
     *
     * @param name Name of the view
     * @param view The view class
     */
    void addView(ViewInterface view) {
        this.views.put(view.getName(), view);
    }

    /**
     * Get a view from the router
     *
     * @param name Name of the view
     * @return
     */
    ViewInterface getView(String name) {
        return this.views.get(name);
    }

    /**
     * Set the root stage for router
     *
     * @param stage Stage
     */
    void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Set the current view on the stage
     *
     * @param name The name of the view to load
     */
    void setView(String name) throws RouterViewNotFoundException {
        if (! this.views.containsKey(name)) {
            throw new RouterViewNotFoundException(name);
        }

        ViewInterface view = this.views.get(name);
        Parent root = this.getFxmlResource(view.getFxmlPath());
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
    private Parent getFxmlResource(String path) {
        try {
            URL url = getClass().getClassLoader().getResource(path);

            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            loader.setControllerFactory(InstanceProvider::getInstance);

            return (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
