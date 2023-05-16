package com.admin4j.limiter.controller;

import com.admin4j.framework.web.pojo.R;
import com.admin4j.limiter.core.anno.RateLimiter;
import com.admin4j.limiter.core.constant.LimiterType;
import com.admin4j.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2023/5/11 15:26
 */
@RestController
@RequestMapping("limiter")
public class LimiterController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("SLIDING_WINDOW")
    @RateLimiter(limiterType = LimiterType.SLIDING_WINDOW, maxAttempts = 5, interval = 10)
    public R SLIDING_WINDOW(String name, Integer id) {

        User user = new User(name, id, "男");
        return R.ok(user);
    }

    @GetMapping("FIX_WINDOW")
    @RateLimiter(limiterType = LimiterType.FIX_WINDOW, maxAttempts = 5, interval = 10)
    public R FIX_WINDOW(String name, Integer id) {

        User user = new User(name, id, "男");
        return R.ok(user);
    }

    @GetMapping("SLIDING_LOG")
    @RateLimiter(limiterType = LimiterType.SLIDING_LOG, maxAttempts = 5, interval = 10)
    public R SLIDING_LOG(String name, Integer id) {

        User user = new User(name, id, "男");
        return R.ok(user);
    }

    @GetMapping("LEAKY_BUCKET")
    @RateLimiter(limiterType = LimiterType.LEAKY_BUCKET, maxAttempts = 5, interval = 10)
    public R LEAKY_BUCKET(String name, Integer id) {

        User user = new User(name, id, "男");
        return R.ok(user);
    }

    @GetMapping("TOKEN_BUCKET")
    @RateLimiter(limiterType = LimiterType.TOKEN_BUCKET, maxAttempts = 5, interval = 10)
    public R TOKEN_BUCKET(String name, Integer id) {

        User user = new User(name, id, "男");
        return R.ok(user);
    }

    @GetMapping("test")
    public R test(String name, Integer id) {

        User user = new User(name, id, id == 1 ? "男" : "女");
        return R.ok(user);
    }
}
