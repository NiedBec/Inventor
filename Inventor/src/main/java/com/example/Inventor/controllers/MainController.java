package com.example.Inventor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Главная страница");
        return "home";
    }
    @GetMapping("/upload")
    public String download(Model model){
        model.addAttribute("title","Страница загрузки/редактирования");
        return "upload";
    }
}
