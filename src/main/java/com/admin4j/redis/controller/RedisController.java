package com.admin4j.redis.controller;

import com.admin4j.framework.web.pojo.R;
import com.admin4j.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andanyang
 * @since 2023/5/15 14:10
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @GetMapping
    public R<User> registerUser(String name) {

        User user1 = redisTemplate.opsForValue().get("register");

        User user = new User();
        user.setName(name);
        user.setAge(user1 == null || user1.getAge() == null ? 18 : (user1.getAge() + 1));
        redisTemplate.opsForValue().set("register", user);
        return R.ok(user1);
    }
}
