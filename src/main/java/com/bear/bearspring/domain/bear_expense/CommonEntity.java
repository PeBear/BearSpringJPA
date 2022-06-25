package com.bear.bearspring.domain.bear_expense;

import com.bear.bearspring.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "common", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CommonEntity extends BaseEntity {

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "key", length = 50)
  private String key;

  @Column(name = "value", length = 250)
  private String value;

  @Column(name = "is_active")
  private Boolean isActive;
}
