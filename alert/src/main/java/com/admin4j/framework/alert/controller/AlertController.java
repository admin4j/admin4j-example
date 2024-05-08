package com.admin4j.framework.alert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2024/5/8 10:21
 */
@RestController
public class AlertController {

    @GetMapping
    public String test() {
        Integer a = 1 / 0;
        return "test";
    }

    @GetMapping("test1")
    public String test1() {
        return "test";
    }
}
