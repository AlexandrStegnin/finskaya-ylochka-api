package com.ddkolesnik.ddkapi;

import com.ddkolesnik.ddkapi.util.AccountingCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Alexandr Stegnin
 */

@SpringBootTest
class FacilityServiceTest {

    @Test
    void test() {
        String facilityName = "72023 Луначарского 27";
        Pattern pattern = Pattern.compile("^\\d{5,}\\.?\\d?\\s+");
        Matcher matcher = pattern.matcher(facilityName);
        assertTrue(matcher.find());
        System.out.println(facilityName.substring(matcher.group().length()));
    }

    @Test
    void enumTest() {
        AccountingCode code = AccountingCode.RESALE_SHARE;
        assertTrue(AccountingCode.isResale(code));
        assertFalse(AccountingCode.isResale(null));
    }
}
