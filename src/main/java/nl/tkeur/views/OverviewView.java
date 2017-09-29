package nl.tkeur.views;

public class OverviewView implements ViewInterface {

    @Override
    public String getTitle() {
        return "Overview";
    }

    @Override
    public String getFxmlPath() {
        return "views/scenes/overview.fxml";
    }
}
