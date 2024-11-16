package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Long> {
}
