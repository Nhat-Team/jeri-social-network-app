package io.github.nhatteam.jeri.service;

import io.github.nhatteam.project.core.annotation.EnableLibraryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibraryCore
public class FriendServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(FriendServiceApplication.class, args);
    }

}
