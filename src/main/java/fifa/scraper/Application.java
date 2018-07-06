package fifa.scraper;

import com.scholastic.ecms.app.ApplicationTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.scholastic.ecms.logging.poc.api", "com.scholastic.ecms.logging.poc.server3"})
public class Application extends ApplicationTemplate {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
