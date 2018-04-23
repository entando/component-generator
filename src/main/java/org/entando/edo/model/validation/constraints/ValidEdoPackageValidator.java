package org.entando.edo.model.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.entando.edo.parser.PackageValidator;

public class ValidEdoPackageValidator implements ConstraintValidator<ValidEdoPackage, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            return PackageValidator.isValidPackageName(value);
        }
    }

}
