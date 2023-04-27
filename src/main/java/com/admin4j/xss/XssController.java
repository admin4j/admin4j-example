package com.admin4j.xss;

import com.admin4j.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

/**
 * @author andanyang
 * @since 2023/4/27 10:08
 */
@RestController
@RequestMapping("xss")
public class XssController {

    @GetMapping
    public String get(String key) {

        return key;
    }

    @PostMapping("form")
    public String form(User user) {

        return JSON.toJSONString(user);
    }

    @PostMapping("form-ignore/**")
    public String formIgnore(User user) {

        return JSON.toJSONString(user);
    }

    @PostMapping("form-include/**")
    public String formInclude(User user) {

        return JSON.toJSONString(user);
    }

    @PostMapping("json")
    public String json(@RequestBody User user) {

        return JSON.toJSONString(user);
    }
}
