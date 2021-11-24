package com.finskaya.ylochka.api.configuration.annotation;

import com.finskaya.ylochka.api.service.app.AppTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Валидация токена приложения
 *
 * @author Alexandr Stegnin
 */

public class AppTokenValidator implements ConstraintValidator<ValidToken, String> {

   @Autowired
   private AppTokenService appTokenService;

   public void initialize(ValidToken constraint) {
   }

   public boolean isValid(String token, ConstraintValidatorContext context) {
      return appTokenService.existByToken(token);
   }

}
