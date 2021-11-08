package com.example.SalesMgmt.Service.ServiceImpl;

import com.example.SalesMgmt.Service.SleuthService;

import javassist.bytecode.stackmap.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class SleuthServiceImpl {

    @Autowired
    private SleuthService sleuthService;

    @GetMapping("/same-span")
    public String helloSleuthSameSpan() throws InterruptedException {
        com.sun.istack.logging.Logger logger = null;
        logger.info("Same Span");
        sleuthService.doSomeWorkSameSpan();
        return "success";
    }
    @Autowired
    private Tracer tracer;

    public <SpanInScope, Span> void doSomeWorkNewSpan() throws InterruptedException {
        com.sun.istack.logging.Logger logger = null;
        logger.info("I'm in the original span");

        Span newSpan = tracer.nextSpan().name("newSpan").start();
        try (SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            logger.info("I'm in the new span doing some cool work that needs its own span");
        } finally {
            newSpan.finish();
        }

        logger.info("I'm in the original span");
    }
}


