package com.bear.bearspring.repository;

import com.bear.bearspring.domain.UserGroupEntity;
import com.bear.bearspring.domain.UserGroupEntity.UserGroupEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, UserGroupEntityId> {

}
