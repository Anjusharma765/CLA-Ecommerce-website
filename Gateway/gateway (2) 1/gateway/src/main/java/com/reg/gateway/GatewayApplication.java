package com.reg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.reg.gateway.filter.AuthenticationFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder rlb, AuthenticationFilter 
	   authenticationFilter) {
	       return rlb
	               .routes()
	               .route(p -> p
	                   .path("/auth/**")
	                   .filters(f -> 
	                   		f.removeRequestHeader("Cookie")
	                   		 .rewritePath("/user-service/(?<segment>.*)", "/$\\{segment}")
	                         .removeResponseHeader("Vary")
                       )
	                .uri("lb://user-service")
	               )
	               .route(p -> p
	                   .path("/req/**")
	                   .filters(f -> 
	                   		f.removeRequestHeader("Cookie")
	                   		 .rewritePath("/admin_service/(?<segment>.*)", "/$\\{segment}")
	                         .filter(authenticationFilter.apply(new AuthenticationFilter.Config()))
	                         .removeResponseHeader("Vary")
                       )
	                .uri("http://localhost:8085")
	               )
	               .route(p -> p
		                   .path("/req/**")
		                   .filters(f -> 
		                   		f.removeRequestHeader("Cookie")
		                   		 .rewritePath("/userprofile/(?<segment>.*)", "/$\\{segment}")
		                         .filter(authenticationFilter.apply(new AuthenticationFilter.Config()))
		                         .removeResponseHeader("Vary")
	                       )
		                .uri("http://localhost:8080")
		               )
	               .route(p -> p
		                   .path("/req/**")
		                   .filters(f -> 
		                   		f.removeRequestHeader("Cookie")
		                   		 .rewritePath("/cart_service/(?<segment>.*)", "/$\\{segment}")
		                         .filter(authenticationFilter.apply(new AuthenticationFilter.Config()))
		                         .removeResponseHeader("Vary")
	                       )
		                .uri("http://localhost:8084")
		               )
	               .route(p -> p
		                   .path("/req/**")
		                   .filters(f -> 
		                   		f.removeRequestHeader("Cookie")
		                   		 .rewritePath("/category_service/(?<segment>.*)", "/$\\{segment}")
		                         .filter(authenticationFilter.apply(new AuthenticationFilter.Config()))
		                         .removeResponseHeader("Vary")
	                       )
		                .uri("http://localhost:8082")
		               )
	            .build();
	}

}
