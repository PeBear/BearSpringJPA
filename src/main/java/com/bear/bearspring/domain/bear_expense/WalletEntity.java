package com.bear.bearspring.domain.bear_expense;

import com.bear.bearspring.domain.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "wallet", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class WalletEntity extends BaseEntity {

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "icon")
  private Integer icon;

  @Column(name = "currency")
  private Integer currency;

  @Column(name = "initial_ammount")
  private BigDecimal initialAmmount;

  @Column(name = "last_amount")
  private BigDecimal lastAmount;

  @Column(name = "loan_interest")
  private BigDecimal loanInterest;

  @Column(name = "saving_interest")
  private BigDecimal savingInterest;

  @Column(name = "credit_interest")
  private BigDecimal creditInterest;
  @Column(name = "term")
  private Integer term;

  @Column(name = "is_deleted")
  private Boolean isDeleted;
}
