package com.example.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SayHiService;

@RestController
public class TestController {
    /**
     * Dubbo服务有依赖时，如A依赖B。B依赖C，那必须要按顺序先启动C，再启动B，最后再启动A。
     * 不然会报错Injection of @Reference dependencies is failed,导致应用无法启动。
     */
    @Reference(retries = 0,check=false)
    private SayHiService sayHiService;

    @GetMapping("/test")
    public String test(String message){
        return sayHiService.say(message);
    }
}
