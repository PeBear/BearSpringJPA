package com.bear.bearspring.repository;

import com.bear.bearspring.domain.GroupEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {

  Optional<GroupEntity> findByName(String name);

  Optional<GroupEntity> findByNameAndIsActiveTrue(String name);
}
