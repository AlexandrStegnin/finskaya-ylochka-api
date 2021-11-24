package com.finskaya.ylochka.api.model.client;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */
@Data
@Entity
@Table(name = "client_decision")
public class ClientDecision {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_decision_generator")
  @SequenceGenerator(name = "client_decision_generator", sequenceName = "client_decision_id_seq")
  Long id;
  @Column(name = "investor_id")
  Long investorId;
  String decision;
  @Column(name = "project_id")
  Long projectId;
  BigDecimal sum;
  
}
