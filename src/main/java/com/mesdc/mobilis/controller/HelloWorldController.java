package com.mesdc.mobilis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mesdc.mobilis.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mesdc.mobilis.domain.User;

@RestController
@RequestMapping("/hello-world")

public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("World");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id ,@RequestParam(value="filter",defaultValue ="nenhum" ) String filter, @RequestBody User body) {
        return filter+ body.getName()+id;
    }
}