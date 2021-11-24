package com.finskaya.ylochka.api.model.balance;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Immutable
@Table(name = "investor_balance")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvestorBalance {

  @Id
  @Column(name = "investor_id")
  Long investorId;

  @Column(name = "account_number")
  String accountNumber;

  @Column(name = "free_cash")
  BigDecimal freeCash;

}
