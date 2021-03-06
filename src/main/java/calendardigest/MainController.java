package calendardigest;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private final Scheduler scheduler;

    @Autowired
    public MainController(final Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @RequestMapping({
            "/",
            "/settings"
    })
    public String redirectOnReload() {
        return "forward:/index.html";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@RequestBody String body) {
        System.out.println(body);
        return "{ \"message\": \"hello from server\" }";
    }

}
