package com.example.ourdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.example.ourdiary")
public class OurdiaryClientAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurdiaryClientAdminApplication.class, args);
    }

}
