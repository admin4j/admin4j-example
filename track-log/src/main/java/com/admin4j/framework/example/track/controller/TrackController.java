package com.admin4j.framework.example.track.controller;

import com.admin4j.framework.example.track.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executor;

/**
 * @author andanyang
 * @since 2024/5/6 15:29
 */
@RestController
@Slf4j

public class TrackController {

    @Autowired
    Executor executor;

    @Autowired
    TrackService trackService;

    @GetMapping()
    public String test() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("Track: {}", request.getContextPath());
        return "Track";
    }

    @GetMapping("Track")
    public String test1() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("Track: {}", request.getContextPath());
        return "Track";
    }

    @GetMapping("Track/1")
    public String test2() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("Track: {}", request.getContextPath());
        return "Track";
    }

    @GetMapping("trackService")
    public String trackService() {

        log.info("TrackService");
        trackService.test();

        return "trackService";
    }

    @GetMapping("executor")
    public String test3() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String contextPath = request.getServletPath();
        log.info("Track: {}", contextPath);

        executor.execute(() -> {
            log.info("executor: {}", contextPath);
        });

        return "Track";
    }

    @GetMapping("executor/2")
    public String executor2() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String contextPath = request.getServletPath() + System.currentTimeMillis();
        log.info("Track: {}", contextPath);

        Thread currented = Thread.currentThread();
        //System.out.println("currented = " + currented);
        executor.execute(() -> {

            Thread subThread = Thread.currentThread();
            //System.out.println("subThread = " + subThread);
            log.info("executor1: {}", contextPath);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("executor2: {}", contextPath);
        });

        return "Track";
    }
}
