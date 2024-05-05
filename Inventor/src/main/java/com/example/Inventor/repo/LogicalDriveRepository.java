package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.LogicalDrive;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LogicalDriveRepository extends CrudRepository<LogicalDrive,Long> {
    List<LogicalDrive> findByReportId(Report report);
}
