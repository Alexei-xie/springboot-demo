package com.itself.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author xxw
 * @Date 2022/11/29
 */
@RestController
public class Lo4jController {

    private static final Logger logger = LoggerFactory.getLogger(Lo4jController.class);

    @GetMapping("/lo4j")
    public String lo4jTest(){
        logger.info("====springboot整合lo4j测试=====");
        return "OK";
    }
}
