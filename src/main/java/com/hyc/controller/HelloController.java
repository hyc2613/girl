package com.hyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hyc26 on 2018-10-25.
 */
@RestController
public class HelloController {

    @GetMapping(value = "/{id}/hello")
    public String say(@PathVariable(name="id") String id) {
        return "hello, "+id;
    }

    @GetMapping({"/hello", "/hi"})
    public String hello(@RequestParam(name = "id", required = true) String id) {
        return "hello, "+id;
    }

}


