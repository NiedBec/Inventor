package com.example.Inventor.controllers;



import com.example.Inventor.models.Report;
import com.example.Inventor.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/report")
    public String reportMain(Model model) {
        Iterable<Report> reports = reportRepository.findAll();
        model.addAttribute("reports",reports);
        return "report-main";
    }
}
