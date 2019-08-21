package com.example.freemarkerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * 请求controller层
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/8/21 0021 16:55
 */
@RestController
public class FirstController {

    @RequestMapping("/")
    public String first(){
        return "Hello World!";
    }

}
