package nl.tkeur;

interface ViewInterface {
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
