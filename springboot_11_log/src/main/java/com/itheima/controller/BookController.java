package com.itheima.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    // 创建记录日志的对象
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public String getById(){
        System.out.println("springboot is running...2");

        log.debug("debug...");
        log.info("info...");
        log.info("warn...");
        log.error("error...");

        return "springboot is running...2";
    }
}
