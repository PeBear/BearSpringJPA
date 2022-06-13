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
@Table(name = "wallet_category", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class WalletCategoryEntity extends BaseEntity {

  @Column(name = "wallet_id")
  private Long walletId;

  @Column(name = "category_id")
  private Long categoryId;

  @Column(name = "index")
  private Integer index;
}
