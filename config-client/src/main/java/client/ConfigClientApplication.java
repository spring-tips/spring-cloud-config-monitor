package client;

/*

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
*/

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Bean
    ApplicationRunner runner() {
        return args ->
                System.getenv().forEach((k, v) -> System.out.println(k + "=" + v));
    }
}

@Controller
@ResponseBody
@RequiredArgsConstructor
class PropertyController {


    private final Environment environment;

    @GetMapping("/value")
    String read() {
        return this.readValue();
    }

    @EventListener({
            RefreshRemoteApplicationEvent.class,
            ApplicationReadyEvent.class,
            RefreshScopeRefreshedEvent.class})
    public void refresh() {
        System.out.println("the new value is " + this.readValue());
    }

    private String readValue() {
        return this.environment.getProperty("cnj.message");
    }
}
