package org.entando.edo.model.json;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.entando.edo.datatype.PrimaryKeyDataType;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoBuilder;
import org.entando.edo.model.EdoConstants;
import org.entando.edo.model.EdoField;
import org.entando.edo.model.validation.constraints.ValidEdoPackage;

public class EdoInput {

    @NotNull
    private String baseDir = EdoConstants.BASE_DIR_DEFAULT;

    @NotNull
    private String permission = EdoConstants.PERMISSION_DEFAULT;

    @ValidEdoPackage(message = BeanModel.ERR_BEANMODEL_PACKAGE)
    private String packageName = "";

    @Valid
    @NotNull
    private BeanModel model = new BeanModel();

    private EdoAssetsConf assets = new EdoAssetsConf();

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public BeanModel getModel() {
        return model;
    }

    public void setModel(BeanModel model) {
        this.model = model;
    }

    public EdoAssetsConf getAssets() {
        return assets;
    }

    public void setAssets(EdoAssetsConf assets) {
        this.assets = assets;
    }

    public EdoBuilder buildEdoBuilder() {
        EdoBuilder builder = new EdoBuilder();
        builder.setBaseDir(this.getBaseDir());
        builder.setPackageName(this.getPackageName());
        builder.setPermission(this.getPermission());
        builder.setAssetsConf(this.getAssets());
        EdoBean edoBean = new EdoBean();
        edoBean.setEdoBuilder(builder);
        edoBean.setName(this.getModel().getName());
        //List<EdoField> fields = new ArrayList<>();
        this.getModel().getFields().forEach((v) -> edoBean.addField(new EdoField(v)));
        //edoBean.setFields(fields);

        this.addDefaultPk(edoBean);
        this.addDefaultPackage(builder);

        builder.getBeans().add(edoBean);
        return builder;
    }

    private void addDefaultPackage(EdoBuilder builder) {
        if (StringUtils.isBlank(builder.getPackageName())) {
            String name = this.getModel().getName();
            String packageName = String.format("org.entando.entando.plugins.jp%s", StringUtils.capitalize(name));
            builder.setPackageName(packageName);
        }
    }

    private void addDefaultPk(EdoBean edoBean) {
        EdoField pk = edoBean.getFields().stream().filter(i -> i.getType().getClass().equals(PrimaryKeyDataType.class)).findFirst().orElse(null);
        if (null != pk) {
            pk.setRequired(true);
            pk.setPrimaryKey(true);
        } else {
            edoBean.addField(EdoField.getDefaultPrimaryKey(), true);
        }
    }

}
