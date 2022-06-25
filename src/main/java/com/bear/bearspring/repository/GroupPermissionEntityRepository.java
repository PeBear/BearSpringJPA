package com.bear.bearspring.repository;

import com.bear.bearspring.domain.GroupPermissionEntity;
import com.bear.bearspring.domain.GroupPermissionEntity.GroupPermissionEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupPermissionEntityRepository extends JpaRepository<GroupPermissionEntity, GroupPermissionEntityId> {

}
