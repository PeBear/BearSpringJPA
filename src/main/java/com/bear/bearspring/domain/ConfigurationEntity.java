package com.bear.bearspring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "configuration")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ConfigurationEntity extends BaseEntity {

  @Column(name = "code", nullable = false, length = 50)
  private String code;

  @Column(name = "value", nullable = false)
  private String value;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "category", length = 100)
  private String category;

  @Column(name = "is_active")
  private Boolean isActive;
}
