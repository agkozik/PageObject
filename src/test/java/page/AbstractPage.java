package page;

public abstract class AbstractPage <E extends AbstractPage> {

    public final int WAIT_TIMEOUT_SECONDS = 15;

    WebDriverManager driverManager = WebDriverManager.getInstance();

    public abstract E initPage();

    public WebDriverManager getDriverManager() {
        return driverManager;
    }
}
