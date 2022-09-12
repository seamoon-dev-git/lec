package com.seamoon.pjt.springcoreprinciple.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoObjectProviderController {

    private final LogDemoObjectProviderService logDemoObjectProviderService;

    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    @RequestMapping("log-demo-object-provider")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoObjectProviderService.logic("testId");
        return "ok";
    }

}
