package com.seamoon.pjt.springcoreprinciple.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoObjectProviderService {

    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String id) {
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = " + id);
    }

}
