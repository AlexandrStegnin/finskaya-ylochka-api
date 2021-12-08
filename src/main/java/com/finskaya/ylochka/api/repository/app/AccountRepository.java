package com.finskaya.ylochka.api.repository.app;

import com.finskaya.ylochka.api.model.app.Account;
import com.finskaya.ylochka.api.util.OwnerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    Account findByOwnerIdAndOwnerType(Long ownerId, OwnerType ownerType);
    boolean existsByAccountNumber(String accountNumber);
    void deleteByOwnerIdAndOwnerType(Long ownerId, OwnerType ownerType);
}
