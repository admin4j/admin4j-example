package com.admin4j.dLock.controller;

import com.admin4j.lock.annotation.DistributedLock;
import com.admin4j.lock.annotation.Idempotent;
import com.admin4j.web.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2023/3/13 14:10
 */
@RestController
@Idempotent
@DistributedLock
public class IdeController {

    @GetMapping("ide")
    public R Idempotent(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }

    @GetMapping("ide2")
    public R ide2(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }
}
