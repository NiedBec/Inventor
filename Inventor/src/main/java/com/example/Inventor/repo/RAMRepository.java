package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.RAM;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RAMRepository extends CrudRepository<RAM,Long> {
    List<RAM> findByReportId(Report report);
}
