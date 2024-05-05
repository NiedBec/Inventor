package com.example.Inventor.repo;

import com.example.Inventor.models.UUIDEntity;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UUIDRepository extends CrudRepository<UUIDEntity,Long> {
    Optional<UUIDEntity> findByReportId(Report report);
}
