package pages;

import objects.Credentials;
import objects.MovieRowData;
import util.DriverFactory;
import java.util.List;

import static pages.PageActions.navigateTo;

public class UIGrabber {

    private DriverFactory driverFactory = new DriverFactory();

    public List<MovieRowData> getResults(String searchRequest) {
        try {
            var pageActions = navigateTo(driverFactory.getDriver());
            pageActions.login(Credentials.getCredentials());
            return pageActions.getSearchResult(searchRequest);
        } finally {
            driverFactory.tearDown();
        }
    }
}
