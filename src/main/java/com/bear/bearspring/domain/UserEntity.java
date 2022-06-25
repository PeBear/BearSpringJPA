package com.bear.bearspring.domain;

import com.bear.bearspring.common.converter.PostgreSQLEnumType;
import com.bear.bearspring.common.enums.EnumUserStatus;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "users")
@TypeDef(
    name = "pgsql_enum",
    typeClass = PostgreSQLEnumType.class
)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public class UserEntity extends BaseEntity {

  @Column(name = "username", nullable = false, length = 50)
  private String username;

  @Column(name = "password", nullable = false, length = 512)
  private String password;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "full_name", nullable = false, length = 200)
  private String fullName;

  @Column(name = "mobile", length = 20)
  private String mobile;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "login_ip", length = 100)
  private String loginIp;

  @Column(name = "login_fail")
  private Integer loginFail;

  @Column(name = "is_forget")
  private Boolean isForget;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  @Type(type = "pgsql_enum")
  private EnumUserStatus status;

  @Column(name = "joined_at")
  private LocalDateTime joinedAt;

  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  @ManyToMany
  @JoinTable(
      name = "user_group",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "group_id"))
  @Exclude
  private List<GroupEntity> groups;
}
