package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.LANCard;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LANCardRepository extends CrudRepository<LANCard,Long> {
    List<LANCard> findByReportId(Report report);
}
