package com.example.Inventor.controllers;



import com.example.Inventor.models.Report;
import com.example.Inventor.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


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

    @GetMapping("/report/add")
    public String reportAdd(Model model) {
        return "report-add";
    }

    @PostMapping("/report/add")
    public String reportPostAdd(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datetime, Model model){
        Report report = new Report(datetime);
        reportRepository.save(report);
        return "redirect:/report";
    }

    @GetMapping("/report/{id}")
    public String reportDetails(@PathVariable(value = "id") long report_id, Model model) {
        if(!reportRepository.existsById(report_id)){
            return "redirect:/report";
        }
        Optional<Report> report = reportRepository.findById(report_id);
        ArrayList<Report> res = new ArrayList<>();
        report.ifPresent(res::add);
        model.addAttribute("report",res);
        return "report-details";
    }
    @GetMapping("/report/{id}/edit")
    public String reportEdit(@PathVariable(value = "id") long report_id, Model model) {
        if(!reportRepository.existsById(report_id)){
            return "redirect:/report";
        }
        Optional<Report> report = reportRepository.findById(report_id);
        ArrayList<Report> res = new ArrayList<>();
        report.ifPresent(res::add);
        model.addAttribute("report",res);
        return "report-edit";
    }

    @PostMapping("/report/{id}/edit")
    public String reportUpdate(@PathVariable(value = "id") long report_id,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datetime, Model model){
        Report report = reportRepository.findById(report_id).orElseThrow();
        report.setDateTime(datetime);
        reportRepository.save(report);
        return "redirect:/report";
    }

    @PostMapping("/report/{id}/remove")
    public String reportDelete(@PathVariable(value = "id") long report_id, Model model){
        Report report = reportRepository.findById(report_id).orElseThrow();
        reportRepository.delete(report);
        return "redirect:/report";
    }
}
