package com.finskaya.ylochka.api.repository.investor;

import com.finskaya.ylochka.api.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface InvestorRepository extends JpaRepository<User, Long> {
}
