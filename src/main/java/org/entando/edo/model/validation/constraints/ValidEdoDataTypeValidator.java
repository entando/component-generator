package org.entando.edo.model.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.entando.edo.datatype.DataTypeManager;

public class ValidEdoDataTypeValidator implements ConstraintValidator<ValidEdoDataType, String> {

  
    @Override
    public void initialize(ValidEdoDataType validEdoDataType) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            return DataTypeManager.getInstance().getDataTypes().containsKey(value);
        }
    }

}
