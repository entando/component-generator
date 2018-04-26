package org.entando.edo.model.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.entando.edo.model.json.EdoInput;

public class ValidBaseDirValidator implements ConstraintValidator<ValidBaseDir, EdoInput> {

    @Override
    public boolean isValid(EdoInput value, ConstraintValidatorContext context) {
        if (StringUtils.isNotBlank(value.getZipDir())) {
            return true;
        } else {
            return StringUtils.isNotBlank(value.getBaseDir());
        }
    }

}
