package com.finskaya.ylochka.api.repository.app;

import com.finskaya.ylochka.api.model.app.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
  List<Phone> findByNumber(String number);
  Phone findByInvestorId(Long investorId);
}
