package io.github.nhatteam.jeri.service;

import io.github.nhatteam.project.core.annotation.EnableLibraryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableLibraryCore
public class UserServiceApplication {

   public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
