package com.example.SalesMgmt.Controller;


import com.example.SalesMgmt.Service.ServiceImpl.UserServiceImpl;
import com.sun.istack.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SleuthController {

    private Logger logger;

    @GetMapping("/")
    public String helloSleuth() {
        logger.info("Hello Sleuth");
        return "success";
    }

    @GetMapping("/new-span")
    public String helloSleuthNewSpan() throws InterruptedException {
        logger.info("New Span");
        UserServiceImpl<Object, Object> sleuthService = null;
        sleuthService.doSomeWorkNewSpan();
        return "success";
    }

}

