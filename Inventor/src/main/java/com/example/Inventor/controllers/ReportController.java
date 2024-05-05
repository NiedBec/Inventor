package com.example.Inventor.controllers;



import com.example.Inventor.dto.ReportInfoDto;
import com.example.Inventor.models.*;
import com.example.Inventor.repo.*;
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
import java.util.List;
import java.util.Optional;


@Controller
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private InformationOSRepository informationOSRepository;
    @Autowired
    private UUIDRepository uuidRepository;
    @Autowired
    private GPURepository gpuRepository;
    @Autowired
    private HDDRepository hddRepository;
    @Autowired
    private LANCardRepository lanCardRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LogicalDriveRepository logicalDriveRepository;
    @Autowired
    private MotherboardRepository motherboardRepository;
    @Autowired
    private NetInfoRepository netInfoRepository;
    @Autowired
    private ProcessorRepository processorRepository;
    @Autowired
    private ProgramsRepository programsRepository;
    @Autowired
    private RamInfoRepository ramInfoRepository;
    @Autowired
    private RAMRepository ramRepository;
    @GetMapping("/report")
    public String reportMain(Model model) {
        Iterable<Report> reports = reportRepository.findAll();
        List<ReportInfoDto> reportInfoDtoList = new ArrayList<>();
        for (Report report : reports) {
            ReportInfoDto reportInfoDto = new ReportInfoDto();
            reportInfoDto.setReportId(report.getId());
            reportInfoDto.setDateTime(report.getDateTime());
            Optional<InformationOS> informationOS = informationOSRepository.findByReportId(report);
            if (informationOS.isPresent()) {
                reportInfoDto.setCsname(informationOS.get().getCsname());
                reportInfoDto.setCaption(informationOS.get().getCaption());
                reportInfoDto.setSerialNumber(informationOS.get().getSerialNumber());
                reportInfoDto.setVersion(informationOS.get().getVersion());
                reportInfoDto.setRegisteredUser(informationOS.get().getRegisteredUser());
                reportInfoDto.setCountryCode(informationOS.get().getCountryCode());
            }
            Optional<UUIDEntity> uuidEntity = uuidRepository.findByReportId(report);
            if (uuidEntity.isPresent()) {
                reportInfoDto.setUuid(uuidEntity.get().getUuid());
            }
            reportInfoDtoList.add(reportInfoDto);
        }
        model.addAttribute("reportInfoDtoList", reportInfoDtoList);
        return "report-main";
    }


    @GetMapping("/report/{id}")
    public String reportDetails(@PathVariable(value = "id") long report_id, Model model) {
        if(!reportRepository.existsById(report_id)){
            return "redirect:/report";
        }
        Optional<Report> report = reportRepository.findById(report_id);
        ReportInfoDto reportInfoDto = new ReportInfoDto();
        reportInfoDto.setReportId(report.get().getId());
        reportInfoDto.setDateTime(report.get().getDateTime());
        Optional<InformationOS> informationOS = informationOSRepository.findByReportId(report.get());
        if (informationOS.isPresent()) {
            reportInfoDto.setCsname(informationOS.get().getCsname());
            reportInfoDto.setCaption(informationOS.get().getCaption());
            reportInfoDto.setSerialNumber(informationOS.get().getSerialNumber());
            reportInfoDto.setVersion(informationOS.get().getVersion());
            reportInfoDto.setRegisteredUser(informationOS.get().getRegisteredUser());
            reportInfoDto.setCountryCode(informationOS.get().getCountryCode());
        }
        Optional<UUIDEntity> uuidEntity = uuidRepository.findByReportId(report.get());
        if (uuidEntity.isPresent()) {
            reportInfoDto.setUuid(uuidEntity.get().getUuid());
        }
        List<GPU> gpus = gpuRepository.findByReportId(report.get());
        reportInfoDto.setGpus(gpus);
        List<HDD> hdds = hddRepository.findByReportId(report.get());
        reportInfoDto.setHdds(hdds);
        List<Processor> processors = processorRepository.findByReportId(report.get());
        reportInfoDto.setCpus(processors);
        List<Motherboard> motherboards = motherboardRepository.findByReportId(report.get());
        reportInfoDto.setMotherboards(motherboards);
        List<LogicalDrive> logicalDrives = logicalDriveRepository.findByReportId(report.get());
        reportInfoDto.setLogicalDrives(logicalDrives);
        List<RAM> rams = ramRepository.findByReportId(report.get());
        reportInfoDto.setRams(rams);
        List<RAMInfo> ramInfos = ramInfoRepository.findByReportId(report.get());
        reportInfoDto.setRamInfos(ramInfos);
        List<LANCard> lanCards = lanCardRepository.findByReportId(report.get());
        reportInfoDto.setLanCards(lanCards);
        List<NetInfo> netInfos = netInfoRepository.findByReportId(report.get());
        reportInfoDto.setNetInfos(netInfos);
        List<Programs> programs = programsRepository.findByReportId(report.get());
        reportInfoDto.setPrograms(programs);
        List<Location> locations = locationRepository.findByReportId(report.get());
        reportInfoDto.setLocations(locations);
        model.addAttribute("reportInfoDto",reportInfoDto);
        return "report-details";
    }

    @PostMapping("/report/{id}/remove")
    public String reportDelete(@PathVariable(value = "id") long report_id, Model model){
        Report report = reportRepository.findById(report_id).orElseThrow();
        List<GPU> gpus = gpuRepository.findByReportId(report);
        List<HDD> hdds = hddRepository.findByReportId(report);
        List<LANCard> lanCards = lanCardRepository.findByReportId(report);
        List<Location> locations = locationRepository.findByReportId(report);
        List<LogicalDrive> logicalDrives = logicalDriveRepository.findByReportId(report);
        List<Motherboard> motherboards = motherboardRepository.findByReportId(report);
        List<NetInfo> netInfos = netInfoRepository.findByReportId(report);
        List<Processor> processors = processorRepository.findByReportId(report);
        List<Programs> programs = programsRepository.findByReportId(report);
        List<RAM> rams = ramRepository.findByReportId(report);
        List<RAMInfo> ramInfos = ramInfoRepository.findByReportId(report);
        Optional<InformationOS> informationOS = informationOSRepository.findByReportId(report);
        Optional<UUIDEntity> uuidEntity = uuidRepository.findByReportId(report);

        if (uuidEntity.isPresent()) {
            uuidRepository.delete(uuidEntity.get());
        }
        ramInfoRepository.deleteAll(ramInfos);
        ramRepository.deleteAll(rams);
        programsRepository.deleteAll(programs);
        processorRepository.deleteAll(processors);
        netInfoRepository.deleteAll(netInfos);
        motherboardRepository.deleteAll(motherboards);
        logicalDriveRepository.deleteAll(logicalDrives);
        locationRepository.deleteAll(locations);
        lanCardRepository.deleteAll(lanCards);
        hddRepository.deleteAll(hdds);
        gpuRepository.deleteAll(gpus);
        if (informationOS.isPresent()) {
            informationOSRepository.delete(informationOS.get());
        }
        reportRepository.delete(report);
        return "redirect:/report";
    }
}
