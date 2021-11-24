package com.finskaya.ylochka.api.repository.balance;

import com.finskaya.ylochka.api.model.balance.InvestorBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface InvestorBalanceRepository extends JpaRepository<InvestorBalance, Long> {

  InvestorBalance findByInvestorId(Long investorId);

}
