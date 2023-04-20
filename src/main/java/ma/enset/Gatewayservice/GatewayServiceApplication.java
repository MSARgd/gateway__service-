package ma.enset.Gatewayservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import utils.RoutesConfig;

@SpringBootApplication
public class GatewayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	/**
	 * Static routes configuration
	 */


	//@Bean
	RouteLocator getWayStaticRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route((r1)-> r1.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
				.route(r2-> r2.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();
	}
	/**
	 *  Dynamic routes configration
	 */
	@Bean
	DiscoveryClientRouteDefinitionLocator getWayDynamicRoutes(
			ReactiveDiscoveryClient rDC, DiscoveryLocatorProperties dLP){
		return  new DiscoveryClientRouteDefinitionLocator(rDC,dLP);
	}

}












