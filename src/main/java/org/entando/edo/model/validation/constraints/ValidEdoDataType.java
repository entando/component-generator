package org.entando.edo.model.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotEmpty;

import org.entando.edo.model.json.BeanModel;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidEdoDataTypeValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, CONSTRUCTOR })
@Retention(RUNTIME)
@NotEmpty(message = BeanModel.ERR_BEANMODEL_FIELD_TYPE_EMPTY)
@ReportAsSingleViolation
public @interface ValidEdoDataType {

    String message() default "{org.entando.edo.model.validation.constraints.ValidEdoDataType.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
