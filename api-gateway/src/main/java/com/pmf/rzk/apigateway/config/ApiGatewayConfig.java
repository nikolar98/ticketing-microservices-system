package com.pmf.rzk.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("user-service", r -> r.path("/users/**")
                        .uri("lb://user-service"))

                .route("ticket-service", r -> r.path("/tickets/**")
                        .uri("lb://ticket-service"))

                .route("assignment-service", r -> r.path("/assignments/**")
                        .uri("lb://assignment-service"))

                .route("notification-service", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))

                .route("activity-service-comments", r -> r.path("/comments/**")
                        .uri("lb://activity-service"))

                .route("activity-service-attachments", r -> r.path("/attachments/**")
                        .uri("lb://activity-service"))

                .route("activity-service-logs", r -> r.path("/activity-logs/**")
                        .uri("lb://activity-service"))

                .build();
    }
}