package com.bear.bearspring.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "group_permission")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class GroupPermissionEntity {

  @EmbeddedId
  private GroupPermissionEntityId id;

  @Embeddable
  @Getter
  @Setter
  @ToString
  @RequiredArgsConstructor
  public static class GroupPermissionEntityId implements Serializable {

    private static final long serialVersionUID = 8099658300764818644L;
    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;

  }
}
