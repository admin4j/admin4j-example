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
public class DLockController {

    @GetMapping("testDLock")
    @DistributedLock(tryLock = true, value = "'testDLock'+#id", user = true)
    public R testDLock(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }

    @GetMapping("keyGenerator")
    @DistributedLock(tryLock = true, user = true)
    public R keyGenerator(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }

    @GetMapping("Idempotent")
    @Idempotent(tryLock = true, key = "Idempotent")
    //@DistributedLock(tryLock = true, user = true)
    public R Idempotent(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }
}
