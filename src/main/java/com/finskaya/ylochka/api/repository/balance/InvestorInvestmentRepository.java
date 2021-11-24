package com.finskaya.ylochka.api.repository.balance;

import com.finskaya.ylochka.api.model.balance.InvestorInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface InvestorInvestmentRepository extends JpaRepository<InvestorInvestment, Long> {

  List<InvestorInvestment> findByInvestorId(Long investorId);

}
