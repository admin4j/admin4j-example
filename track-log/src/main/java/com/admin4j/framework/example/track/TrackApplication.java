package com.admin4j.framework.example.track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author andanyang
 * @since 2024/5/6 15:29
 */
@SpringBootApplication
@EnableAsync
public class TrackApplication {

    public static void main(String[] args) {

        SpringApplication.run(TrackApplication.class, args);
    }
}
