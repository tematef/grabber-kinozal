package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import apiclient.KinozalApiClient;
import objects.MovieRowData;
import org.springframework.web.bind.annotation.*;
import pages.UIGrabber;
import util.SearchQueryBuilder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GrabController {

    private static final String STATUS_TEMPLATE = "{ kinozal_status : %s }";
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/status")
    public String status() {
        return String.format(STATUS_TEMPLATE, new KinozalApiClient().getStatusCode());
    }

    @RequestMapping(value = "/grab/{request}", method = GET)
    @ResponseBody
    public List<MovieRowData> grab(@PathVariable("request") String request) {
        return new UIGrabber().getDistinctResults(request);
    }

    @RequestMapping(value = "/grab/movie/quality/{quality}/year/{year}/text/{text}", method = GET)
    @ResponseBody
    public List<MovieRowData> grabMovies(@PathVariable("quality") String quality,
                                         @PathVariable("year") String year,
                                         @RequestParam(value = "text", defaultValue = "") String text) {
        return new UIGrabber().getDistinctResults(SearchQueryBuilder.buildMovieSearch(text, quality, year));
    }
}
