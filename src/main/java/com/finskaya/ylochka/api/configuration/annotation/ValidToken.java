package com.finskaya.ylochka.api.configuration.annotation;

import com.finskaya.ylochka.api.util.Constant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AppTokenValidator.class)
public @interface ValidToken {

    Class<?>[] groups() default {};

    String message() default Constant.INVALID_APP_TOKEN;

    Class<? extends Payload>[] payload() default {};

}
