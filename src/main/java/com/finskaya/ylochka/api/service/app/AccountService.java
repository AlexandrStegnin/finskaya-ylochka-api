package com.finskaya.ylochka.api.service.app;

import com.finskaya.ylochka.api.model.app.Account;
import com.finskaya.ylochka.api.model.app.Investor;
import com.finskaya.ylochka.api.repository.app.AccountRepository;
import com.finskaya.ylochka.api.util.OwnerType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Alexandr Stegnin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

  AccountRepository accountRepository;

  public void createAccount(Investor user) {
    var account = Account.builder()
        .accountNumber(user.getPhone())
        .ownerId(user.getId())
        .ownerType(OwnerType.INVESTOR)
        .ownerName(user.getLogin())
        .build();

    log.info("Create account {}", account);
    accountRepository.save(account);
  }

}
