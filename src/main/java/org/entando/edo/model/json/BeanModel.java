package org.entando.edo.model.json;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.entando.edo.model.validation.constraints.ValidEdoClassName;

public class BeanModel {

    public static final String ERR_BEANMODEL_FIELD_LIST_EMPTY = "Fields cannot be empty";
    public static final String ERR_BEANMODEL_FIELD_LIST_NULL = "Fields cannot be null";

    public static final String ERR_BEANMODEL_FIELD_NAME_EMPTY = "Field name is required";
    public static final String ERR_BEANMODEL_FIELD_TYPE_EMPTY = "Field type is required";
    public static final String ERR_BEANMODEL_FIELD_TYPE_INVALID = "Field type '${validatedValue}' is not valid. Use one of: int, date, string, bigdecimal, primary_key";
    public static final String ERR_BEANMODEL_PACKAGE = "Invalid package definition '${validatedValue}'";
    public static final String ERR_BEANMODEL_NAME = "Invalid class name '${validatedValue}'";
    public static final String ERR_BEANMODEL_BASEDIR = "Invalid baseDir '${validatedValue.baseDir}' specified. This value is required when -z option is not speficied";

    @ValidEdoClassName(message = ERR_BEANMODEL_NAME)
    private String name;

    @Valid
    @NotNull(message = ERR_BEANMODEL_FIELD_LIST_NULL)
    @Size(min = 1, message = ERR_BEANMODEL_FIELD_LIST_EMPTY)

    @JsonProperty("fields")
    private List<Field> fields = new ArrayList<>();

    public BeanModel() {

    }

    public BeanModel(String name) {
        this.setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public Map<String, Field> getFields() {
    //        return fields;
    //    }
    //
    //    public void setFields(Map<String, Field> fields) {
    //        this.fields = fields;
    //    }

    public void addField(String name, String type, boolean required) {
        this.getFields().add(new Field(name, type, required));

    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}
