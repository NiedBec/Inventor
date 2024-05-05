package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.Processor;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProcessorRepository extends CrudRepository<Processor,Long> {
    List<Processor> findByReportId(Report report);
}
