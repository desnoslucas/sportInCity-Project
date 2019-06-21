package com.projetperso.app.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {

    @GetMapping (value="/")
    public String displayIndex (){
        return "index";

    }
}
