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
@Table(name = "profile", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProfileEntity extends BaseEntity {

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "currency")
  private Integer currency;

  @Column(name = "is_deleted")
  private Boolean isDeleted;
}
