package com.bear.bearspring.domain.bear_expense;

import com.bear.bearspring.domain.BaseEntity;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "transaction", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TransactionEntity extends BaseEntity {

  @Column(name = "wallet_id")
  private Integer walletId;

  @Column(name = "category_id")
  private Integer categoryId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "date")
  private Instant date;

  @Column(name = "memo", length = 250)
  private String memo;

  @Column(name = "created_at")
  private Instant createdAt;
  @Column(name = "modified_at")
  private Instant modifiedAt;
}
