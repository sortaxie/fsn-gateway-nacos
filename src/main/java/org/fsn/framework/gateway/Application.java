package org.fsn.framework.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;


/**
 * Created by sorta on 8/26/19.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).run(args);
    }



    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
