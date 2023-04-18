package com.admin4j.dLock.controller;

import com.admin4j.framework.lock.annotation.DistributedLock;
import com.admin4j.framework.lock.annotation.Idempotent;
import com.admin4j.framework.lock.util.DistributedLockUtil;
import com.admin4j.framework.web.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2023/3/13 14:10
 */
@RestController
public class DLockController {

    @GetMapping("testDLock")
    @DistributedLock(tryLock = false, value = "'testDLock:'+#id", user = true)
    public R testDLock(String name, Integer id) throws InterruptedException {

        Thread.sleep(30000);
        return R.ok();
    }

    @GetMapping("tryLock")
    @DistributedLock(tryLock = true, value = "'tryLock:'+#id", user = true)
    public R tryLock(String name, Integer id) throws InterruptedException {

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

    @GetMapping("util")
    //@DistributedLock(tryLock = true, user = true)
    public R util(String name, Integer id) throws InterruptedException {

        DistributedLockUtil.lock("util：" + id, () -> {
            System.out.println("i get the lock   = " + name);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return R.ok();
    }

    @GetMapping("tryLockutil")
    //@DistributedLock(tryLock = true, user = true)
    public R tryLockutil(String name, Integer id) throws InterruptedException {

        DistributedLockUtil.tryLockWithError("util：" + id, () -> {
            System.out.println("i get the lock   = " + name);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return R.ok();
    }
}
