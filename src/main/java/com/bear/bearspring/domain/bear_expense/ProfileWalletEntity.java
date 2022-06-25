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
@Table(name = "profile_wallet", schema = "expense_note")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProfileWalletEntity extends BaseEntity {

  @Column(name = "profile_id")
  private Integer profileId;

  @Column(name = "wallet_id")
  private Integer walletId;

  @Column(name = "index")
  private Integer index;

}
