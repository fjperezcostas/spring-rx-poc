package fjpc.labs.springrxpoc.rxproxy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class Application {

    private final WebClient webClient;

    public Application() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/greetings")
    public Mono<String> greet(@RequestParam int delay) {
        return webClient.get().uri("/greetings?delay=" + delay).retrieve().bodyToMono(String.class);
    }

}

