package com.miracle.springcloud.controller;

import com.miracle.springcloud.service.IMessage;
import com.miracle.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private MessageProviderImpl iMessage;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessage.send();
    }


}
