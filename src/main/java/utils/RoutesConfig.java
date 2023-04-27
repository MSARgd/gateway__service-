package utils;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
public class RoutesConfig {
    public RoutesConfig() {
    }

//    @Bean
    RouteLocator getWayStaticRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route((r1)-> r1.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(r2-> r2.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();


    

    }
}