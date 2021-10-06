package cnj.basics;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicsApplication.class, args);
    }

}

@Component
@RequiredArgsConstructor
class PropertyListener {

    private final Environment environment;

    @EventListener({
            RefreshRemoteApplicationEvent.class,
            ApplicationReadyEvent.class,
            RefreshScopeRefreshedEvent.class})
    public void refresh() {
        System.out.println("the new value is " + this.environment.getProperty("cnj.message"));
    }
}