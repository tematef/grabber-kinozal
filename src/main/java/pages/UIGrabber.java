package pages;

import objects.Credentials;
import objects.MovieRowData;
import util.DriverFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<MovieRowData> getDistinctResults(String searchRequest) {
        Map<String, MovieRowData> map = new HashMap<>();
        for (MovieRowData item : getResults(searchRequest)) {
            if (!map.containsKey(item.getNameEng()) || map.get(item.getNameEng()).getSize() < item.getSize()) {
                map.put(item.getNameEng(), item);
            }
        }
        return new ArrayList(map.values());
    }
}
