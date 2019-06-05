package com.example.demo.demo01;

import org.springframework.web.bind.annotation.*;

/**
 * @auther kklu
 * @date 2019/6/4 11:37
 * @describe
 */
@RestController
public class HelloController {

    @RequestMapping(name = "/hello", method = RequestMethod.GET)
    public String hello() {

        return "Hello RequestMapping";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String say() {
        return "Hello GetMapping";
    }
}
