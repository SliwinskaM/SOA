package pl.edu.agh.soa.lab;

import io.swagger.jaxrs.config.BeanConfig;
import pl.edu.agh.soa.lab.api.MainRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class APIApplication extends Application {
    public APIApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/Zad11111-web/api");
        beanConfig.setScan(true);
    }
}

