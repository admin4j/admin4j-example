package com.admin4j.framework.example.controller;

import com.admin4j.framework.lock.annotation.DistributedLock;
import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2024/1/29 18:10
 */
@RestController
@RequestMapping("lock")
public class LockController {

    @GetMapping("/{key}")
    @DistributedLock("'lock'+#p0")
    public String getLock(@PathVariable String key) throws InterruptedException {

        Thread.sleep(ThreadLocalRandom.current().nextInt(1000,10000));
        return key;
    }
}
