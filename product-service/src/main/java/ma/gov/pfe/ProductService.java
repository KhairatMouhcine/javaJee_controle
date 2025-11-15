package ma.gov.pfe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class ProductService {
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(ProductService.class);
        Environment env = app.run(args).getEnvironment();

        log.info("Access URLs:\n----------------------------------------------------------\n" +
                        "Url Swagger: \thttp://127.0.0.1:{}/swagger-ui/index.html\n" +
                        "Url H2 Base: \thttp://127.0.0.1:{}/h2-console\n" +
                        "----------------------------------------------------------",
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }
}