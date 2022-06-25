package com.bear.bearspring.repository;

import com.bear.bearspring.domain.ConfigurationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Integer> {

  List<ConfigurationEntity> findByIsActiveTrue();
}
