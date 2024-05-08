package com.admin4j.framework.example.track.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author andanyang
 * @since 2024/5/7 15:01
 */
@Service
@Slf4j
public class TrackService {

    @Async
    public void test() {
        log.info("TrackService1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("TrackService2");
    }
}
