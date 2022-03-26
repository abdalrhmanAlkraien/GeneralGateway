package com.example.gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public CommandLineRunner test(RouteLocator routeLocator)
    {
        return args-> {
            routeLocator
                    .getRoutes()
                    .subscribe(r->{
                        System.out.println(r.getFilters());
                        System.out.println(r.getUri());
                        System.out.println(r);
                    });
        };

    }
}
