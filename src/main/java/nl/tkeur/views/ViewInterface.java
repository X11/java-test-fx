package nl.tkeur.views;

public interface ViewInterface {

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
}
