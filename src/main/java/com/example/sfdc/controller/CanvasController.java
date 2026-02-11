package com.example.sfdc.controller;

import com.example.sfdc.service.SalesforceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canvas")
public class CanvasController {

    private final SalesforceService service;

    public CanvasController(SalesforceService service) {
        this.service = service;
    }

    @GetMapping("/userinfo")
    public String userInfo(@RequestParam String token,
                           @RequestParam String instanceUrl) {
        return service.getUserInfo(token, instanceUrl);
    }
    
    @PostMapping("/sf/canvas")
    public String canvasEntry(@RequestParam("signed_request") String signedRequest) {

        System.out.println("Canvas 请求到了！");
        System.out.println("signed_request = " + signedRequest);

        return "<h2>Canvas 已成功连接到你的 Java 服务器 🎉</h2>";
    }
}
