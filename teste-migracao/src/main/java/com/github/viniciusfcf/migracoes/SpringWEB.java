package com.github.viniciusfcf.migracoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springWEB")
public class SpringWEB {

    @GetMapping
    public String hello() {
        return "hello Spring WEB";
    }
}