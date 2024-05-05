package com.example.Inventor.repo;

import com.example.Inventor.models.GPU;
import com.example.Inventor.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

public interface GPURepository extends CrudRepository<GPU, Long> {
    List<GPU> findByReportId(Report report);
}
