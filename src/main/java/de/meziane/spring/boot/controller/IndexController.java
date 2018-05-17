package de.meziane.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        final Logger logger = LoggerFactory.getLogger(IndexController.class);
        logger.info(">>>>>>>>>>>>>>>>>>   REQUEST RECEIVED   <<<<<<<<<<<<<<<<<<<<");
        return "index";
    }

}
