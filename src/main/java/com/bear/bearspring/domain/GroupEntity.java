package com.bear.bearspring.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name = "\"group\"")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class GroupEntity extends BaseEntity {

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "is_active")
  private Boolean isActive;

  @ManyToMany(mappedBy = "groups")
  @Exclude
  private List<UserEntity> users;

  @ManyToMany
  @JoinTable(
      name = "group_permission",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  @Exclude
  private List<PermissionEntity> permissions;
}
