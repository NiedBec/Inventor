package com.example.Inventor.repo;

import com.example.Inventor.models.HDD;
import com.example.Inventor.models.NetInfo;
import com.example.Inventor.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NetInfoRepository extends CrudRepository<NetInfo,Long> {
    List<NetInfo> findByReportId(Report report);
}
