package com.dwfs.clam.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class testController {
    @Value("${test.name}")
    private String name;
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    private String hello(){
        return "hello"+name;
    }
}
