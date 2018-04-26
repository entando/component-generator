package org.entando.edo.model.json;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EdoInputTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testModel() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        edoInput.setPackageName("org.entando.entando.plugins.jpcity");

        BeanModel beanModel = new BeanModel("City");
        beanModel.addField("name", "string", true);
        beanModel.addField("temp", "int", false);

        edoInput.setModel(beanModel);
        ObjectMapper mapper = new ObjectMapper();
        String x = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edoInput);
        //System.out.println(x);
        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        assertThat(constraintViolations.size(), is(0));
    }

    @Test
    public void testModelWithNullFields() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        BeanModel beanModel = new BeanModel("City");
        beanModel.setFields(null);
        edoInput.setModel(beanModel);
        //ObjectMapper mapper = new ObjectMapper();
        //String x = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edoInput);
        //System.out.println(x);
        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        List<String> messages = constraintViolations.stream().map(i -> i.getMessage()).collect(Collectors.toList());
        System.out.println(StringUtils.join(messages, "\n"));
        assertThat(constraintViolations.size(), is(2));
        assertThat(messages, hasItem(BeanModel.ERR_BEANMODEL_FIELD_LIST_NULL));
    }

    @Test
    public void testModelWithEmptyFields() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        BeanModel beanModel = new BeanModel("City");
        edoInput.setModel(beanModel);
        //ObjectMapper mapper = new ObjectMapper();
        //String x = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edoInput);
        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        List<String> messages = constraintViolations.stream().map(i -> i.getMessage()).collect(Collectors.toList());
        System.out.println(StringUtils.join(messages, "\n"));
        assertThat(constraintViolations.size(), is(2));
        assertThat(messages, hasItems(
                                      BeanModel.ERR_BEANMODEL_FIELD_LIST_EMPTY,
                                      "Invalid package definition ''"));
    }

    @Test
    public void testModelWithInvalidFieldName() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        BeanModel beanModel = new BeanModel("Car");
        beanModel.addField("", "string", true);
        edoInput.setModel(beanModel);

        //ObjectMapper mapper = new ObjectMapper();
        //String x = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edoInput);

        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        List<String> messages = constraintViolations.stream().map(i -> i.getMessage()).collect(Collectors.toList());
        System.out.println(StringUtils.join(messages, "\n"));
        assertThat(constraintViolations.size(), is(2));

        assertThat(messages, hasItem(BeanModel.ERR_BEANMODEL_FIELD_NAME_EMPTY));
    }

    @Test
    public void testModelWithNullFieldType() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        BeanModel beanModel = new BeanModel("Car");
        beanModel.addField("model", "", true);
        edoInput.setModel(beanModel);

        ObjectMapper mapper = new ObjectMapper();
        String x = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edoInput);
        System.out.println(x);
        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        assertThat(constraintViolations.size(), is(2));
        List<String> messages = constraintViolations.stream().map(i -> i.getMessage()).collect(Collectors.toList());
        assertThat(messages, hasItem("Field type '' is not valid. Use one of: int, date, string, bigdecimal, primary_key"));
    }

    @Test
    public void testModelWithNullBaseDir() throws JsonProcessingException {
        EdoInput edoInput = new EdoInput();
        edoInput.setBaseDir("");
        edoInput.setPackageName("com.foo");
        BeanModel beanModel = new BeanModel("Car");
        beanModel.addField("model", "string", true);
        beanModel.addField("name", "string", false);
        edoInput.setModel(beanModel);
        Set<ConstraintViolation<EdoInput>> constraintViolations = validator.validate(edoInput);
        List<String> messages = constraintViolations.stream().map(i -> i.getMessage()).collect(Collectors.toList());
        System.out.println(StringUtils.join(messages, "\n"));
        assertThat(constraintViolations.size(), is(1));
        assertThat(messages, hasItem("Invalid baseDir '' specified. This value is required when -z option is not speficied"));
    }


}
