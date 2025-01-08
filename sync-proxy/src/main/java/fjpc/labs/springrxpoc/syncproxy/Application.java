package fjpc.labs.springrxpoc.syncproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

    private final RestTemplate http;

    public Application() {
        http = new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/greetings")
    public String greet(@RequestParam int delay) {
        return http.getForObject("http://localhost:8082/greetings?delay=" + delay, String.class);
    }
}
