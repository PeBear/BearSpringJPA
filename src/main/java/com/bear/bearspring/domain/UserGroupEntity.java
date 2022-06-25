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
import lombok.experimental.Accessors;

@Entity
@Table(name = "user_group")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public class UserGroupEntity {

  @EmbeddedId
  private UserGroupEntityId id;

  public UserGroupEntityId getId() {
    return id;
  }

  public void setId(UserGroupEntityId id) {
    this.id = id;
  }

  @Embeddable
  @Getter
  @Setter
  @ToString
  @RequiredArgsConstructor
  @Accessors(chain = true)
  public static class UserGroupEntityId implements Serializable {

    private static final long serialVersionUID = 5960671277881569226L;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;
  }
}
