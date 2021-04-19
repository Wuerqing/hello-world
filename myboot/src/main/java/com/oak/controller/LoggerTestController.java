package com.oak.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerTestController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log")
    public String testLog(){
        logger.debug("=====测试debug日志====");
        logger.info("=====测试info日志====");
        logger.warn("=====测试warn日志====");
        logger.error("=====测试error日志====");

        logger.info("==帅哥：{}，美女：{}","吴","天");
        return "success";
    }
}
