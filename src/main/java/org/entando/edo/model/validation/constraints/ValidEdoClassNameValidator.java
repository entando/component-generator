package org.entando.edo.model.validation.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEdoClassNameValidator implements ConstraintValidator<ValidEdoDataType, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            return isValidClassName(value);
        }
    }

    protected boolean isValidClassName(String arg) {
        Pattern pattern = Pattern.compile("([A-Z])([\\w]*)*");
        Matcher matcher = pattern.matcher(arg);
        return matcher.matches();
    }
}
