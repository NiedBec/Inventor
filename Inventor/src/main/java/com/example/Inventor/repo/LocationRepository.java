package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.Location;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location,Long> {
    List<Location> findByReportId(Report report);
}
