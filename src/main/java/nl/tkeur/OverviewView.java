package nl.tkeur;

public class OverviewView implements ViewInterface {

    private AuthenticationServiceInterface authenticationService;

    public OverviewView(AuthenticationServiceInterface authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public String getName() {
        return "default/overview";
    }

    @Override
    public String getTitle() {
        return "Overview";
    }

    @Override
    public String getFxmlPath() {
        return "views/wrappers/default_overview.fxml";
    }

    @Override
    public boolean beforeViewEnter() {
        return this.authenticationService.isAuthenticated();
    }
}
