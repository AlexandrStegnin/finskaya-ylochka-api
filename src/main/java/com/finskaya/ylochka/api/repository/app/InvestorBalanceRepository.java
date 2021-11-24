package com.finskaya.ylochka.api.repository.app;

import com.finskaya.ylochka.api.model.app.InvestorBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface InvestorBalanceRepository extends JpaRepository<InvestorBalance, Long> {

  InvestorBalance findByInvestorId(Long investorId);

}
