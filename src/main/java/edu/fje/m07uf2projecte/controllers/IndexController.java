package edu.fje.m07uf2projecte.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String inici() {
        System.out.println("HOLA PIBE");
        return "index";
    }
}
