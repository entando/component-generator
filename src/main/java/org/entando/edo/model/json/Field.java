package org.entando.edo.model.json;

import javax.validation.constraints.NotEmpty;

import org.entando.edo.model.validation.constraints.ValidEdoDataType;

public class Field {

    @NotEmpty(message = BeanModel.ERR_BEANMODEL_FIELD_NAME_EMPTY)
    private String name;


    @ValidEdoDataType(message = BeanModel.ERR_BEANMODEL_FIELD_TYPE_INVALID)
    private String type;

    private boolean required;

    private Integer length;

    private boolean primaryKey = false;

    public Field() {

    }

    public Field(String name, String type, boolean required) {
        this.setName(name);
        this.setType(type);
        this.setRequired(required);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

}
