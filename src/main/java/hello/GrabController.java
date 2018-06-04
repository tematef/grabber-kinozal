package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import apiclient.KinozalApiClient;
import org.springframework.web.bind.annotation.*;
import pages.UIGrabber;

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

    @RequestMapping("/grab")
    public @ResponseBody List<String> grab(@RequestParam(value="request") String request) {
        return new UIGrabber().getDistinctResults(request).stream().map(item -> item.toString()).collect(Collectors.toList());
    }
}
