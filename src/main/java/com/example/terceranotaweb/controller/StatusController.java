package com.example.terceranotaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/healthcheck")
    public String status(){ return "OK";}

    public String error() {return "Error";}
}
