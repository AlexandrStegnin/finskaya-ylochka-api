package com.finskaya.ylochka.api.repository.app;

import com.finskaya.ylochka.api.model.app.AppToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */

@Repository
public interface AppTokenRepository extends JpaRepository<AppToken, Long> {

    Boolean existsByToken(String token);

}
