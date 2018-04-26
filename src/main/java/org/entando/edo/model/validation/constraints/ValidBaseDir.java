package org.entando.edo.model.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidBaseDirValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface ValidBaseDir {

    String message() default "{org.entando.edo.model.validation.constraints.ValidBaseDir.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
