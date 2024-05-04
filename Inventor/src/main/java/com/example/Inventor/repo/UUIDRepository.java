package com.example.Inventor.repo;

import com.example.Inventor.models.UUIDEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UUIDRepository extends CrudRepository<UUIDEntity,Long> {
}
