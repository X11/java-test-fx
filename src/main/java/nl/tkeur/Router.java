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
    private HashMap<String, Route> views;

    public Router() {
        this.views = new HashMap<>();
    }

    /**
     * Add a new view to the router
     *
     * @param view The view class
     */
    void addRoute(Route view) {
        this.views.put(view.getName(), view);
    }

    /**
     * Get a view from the router
     *
     * @param name Name of the view
     * @return
     */
    Route getRoute(String name) {
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
    void setRoute(String name) throws RouterViewNotFoundException, RouterBeforeViewEnterException {
        if (! this.views.containsKey(name)) {
            throw new RouterViewNotFoundException(name);
        }

        Route view = this.views.get(name);
        if (! view.beforeViewEnter()) {
            throw new RouterBeforeViewEnterException(view);
        }

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

    interface Route {
        /**
         * Get the views name
         *
         * @return
         */
        String getName();

        /**
         * Get the title for the view
         *
         * @return String
         */
        String getTitle();

        /**
         * Get the path for the fxml file
         *
         * @return String
         */
        String getFxmlPath();

        /**
         * Hook for before the router to a view. This can be used to check whether a user is authenticated or not.
         *
         * @return
         */
        default boolean beforeViewEnter() {
            return true;
        }

    }
}
