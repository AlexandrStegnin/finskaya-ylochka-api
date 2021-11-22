package com.ddkolesnik.ddkapi.util;

import java.math.BigDecimal;

/**
 * @author Alexandr Stegnin
 */

public class TestCase {

  public static void main(String[] args) {
    BigDecimal inaccuracy = BigDecimal.valueOf(0.5);
    BigDecimal sellerSum = BigDecimal.valueOf(200000.01);
    BigDecimal buyerSum = BigDecimal.valueOf(200000);
    System.out.println(buyerSum.compareTo(sellerSum.subtract(inaccuracy)) >= 0);
    System.out.println(buyerSum.compareTo(sellerSum.add(inaccuracy)) <= 0);

  }

}
