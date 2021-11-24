package com.finskaya.ylochka.api.repository.client;

import com.finskaya.ylochka.api.model.client.ClientDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandr Stegnin
 */
@Repository
public interface ClientDecisionRepository extends JpaRepository<ClientDecision, Long> {
}
