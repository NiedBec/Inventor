package com.example.Inventor.controllers;

import com.example.Inventor.services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public String uploadCsv(@RequestParam("file") MultipartFile file) {
        csvService.processCsv(file);
        return "redirect:/report";
    }
}
