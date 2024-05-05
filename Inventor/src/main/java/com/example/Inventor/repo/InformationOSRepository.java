package com.example.Inventor.repo;

import com.example.Inventor.models.InformationOS;
import com.example.Inventor.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InformationOSRepository extends CrudRepository<InformationOS, Long> {
    Optional<InformationOS> findByReportId(Report report);
}
