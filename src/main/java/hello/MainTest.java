package hello;

import objects.MovieRowData;
import pages.UIGrabber;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        UIGrabber grabber = new UIGrabber();
        Map<String, MovieRowData> map = new HashMap<>();
        List<MovieRowData> a = grabber.getResults("&s=&g=0&c=1002&v=7&d=2018&w=0&t=0&f=0");
        List<MovieRowData> b = new UIGrabber().getDistinctResults("&s=&g=0&c=1002&v=7&d=2018&w=0&t=0&f=0");
        int c=1;
//        for (MovieRowData item : a) {
//            if (!map.containsKey(item.getNameEng()) || map.get(item.getNameEng()).getSize() < item.getSize()) {
//                map.put(item.getNameEng(), item);
//            }
//        }
//        Collection<MovieRowData> distinct = map.values();
//        a.forEach(item -> {
//            if (map.containsKey(item.getNameEng()) && map.get(item.getNameEng()).getSize() < item.getSize()) {
//                map.put(item.getNameEng(), item);
//            }
//        });
    }
}
