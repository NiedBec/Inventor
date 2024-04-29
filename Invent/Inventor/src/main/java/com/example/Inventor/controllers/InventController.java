package com.example.Inventor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventController {
    @GetMapping("/")
    public String Invent(){
        return "invents";
    }
}
