package com.bear.bearspring.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name = "permission")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PermissionEntity extends BaseEntity {

  @Column(name = "code", nullable = false, length = 50)
  private String code;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "category", length = 100)
  private String category;

  @Column(name = "is_active")
  private Boolean isActive;

  @ManyToMany(mappedBy = "permissions")
  @Exclude
  private List<GroupEntity> groups;
}
