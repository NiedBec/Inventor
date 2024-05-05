package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.RAMInfo;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RamInfoRepository extends CrudRepository<RAMInfo,Long> {

    List<RAMInfo> findByReportId(Report report);
}
