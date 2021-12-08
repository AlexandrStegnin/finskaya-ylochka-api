package com.finskaya.ylochka.api.repository.app;

import com.finskaya.ylochka.api.model.app.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
  @Query("SELECT max(cast(substring(u.login, 9) as int)) from Investor u where u.login like 'investor%'")
  Integer selectLastInvestorNumber();

  Investor findByPhone(String phone);
}
