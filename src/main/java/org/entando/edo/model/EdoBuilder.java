/*
 * Copyright 2015-Present Entando Inc. (http://www.entando.com) All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package org.entando.edo.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.entando.edo.builder.FolderConstants;

public class EdoBuilder {

	public void addBean (EdoBean edoBean) {
		edoBean.setEdoBuilder(this);
		this.getBeans().add(edoBean);
	}

	public EdoBean getBean() {
		return this.getBeans().get(0);
	}

	public boolean isPlugin() {
		return this.getPackageName().contains(".plugins.");
	}

	public String getPluginName() {
		String name = null;
		if (isPlugin()) {
			name = StringUtils.substringAfter(this.getPackageName(), ".plugins.");
		}
		return name;
	}

	public String getProjectName() {
		String name = StringUtils.substringAfterLast(this.getBaseDir(), File.separator);
		name = name.replaceAll("_", "");
		name = name.replaceAll("-", "");
		return StringUtils.uncapitalize(name);
	}

	/**
	 * @return
	 */
	public String getPackageFolder() {
		return this.getPackageName().replaceAll("\\.", "/");
	}

	//XXX
	public String getSpringBeanPreposition() {
		String name = StringUtils.substringAfterLast(this.getBaseDir(), File.separator);
		name = name.replaceAll("_", "");
		name = name.replaceAll("-", "");
		if (isPlugin()) {
			String pname = StringUtils.substringAfter(this.getPackageName(), ".plugins.");
			name = pname.split("\\.")[0];
		}
		return name;
	}


	public String getJavaFolder() {
		String pojoPath = this.getBaseDir() + FolderConstants.getJavaFolder() + this.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) +  File.separator;
		return pojoPath;
	}

	public String getJavaTestFolder() {
		String pojoPath = this.getBaseDir() + FolderConstants.getJavaTestFolder() + this.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) +  File.separator;
		return pojoPath;
	}

	/**
	 * 
	 * @return .../aps/system/services/
	 */
	public String getJavaServicesFolder() {
		String pojoPath = this.getJavaFolder() + FolderConstants.getServicesFolder() + File.separator;
		return pojoPath;
	}

	/**
	 * 
	 * @return ...src/main/java/apsadmin/
	 */
	public String getJavaControllerFolder() {
		String pojoPath = this.getJavaFolder() + "apsadmin" + File.separator;
		return pojoPath;
	}

	/**
	 * 
	 * @return ...src/main/java/aps/internalservlet
	 */
	public String getJavaControllerInternalServletFolder() {
		String pojoPath = this.getJavaFolder() + "aps" + File.separator + "internalservlet"  + File.separator;
		return pojoPath;
	}

	//--------------------------
	/**
	 * 
	 * @return .../src/main/resources/plugin|project/dirName/whatever/subDirName
	 */
	public String getResourcesConfigFolder(String dirName, String subDirName) {
		String folderPath = this.getBaseDir() + FolderConstants.getResourcesFolder() + dirName + File.separator;
		if (this.isPlugin()) {
			folderPath = folderPath + "plugins" + File.separator + this.getPluginName() + File.separator;
		} else {
			folderPath = folderPath + this.getProjectName() + File.separator;	
		}
		if (StringUtils.isNotBlank(subDirName)) {
			folderPath = folderPath + subDirName + File.separator;
		}
		return folderPath;
	}


	public String getTldFolder() {
		String pojoPath = this.getBaseDir() + FolderConstants.getTldFolder();
		if (this.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + this.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + this.getProjectName() + File.separator;	
		}
		return pojoPath;
	}

	//-------------------------------------
	/**
	 * 
	 * @return  .../src/main/resources/spring/whatever/managers/
	 */
	public  String getSpringManagerConfigFolder() {
		String apsSpringPath = this.getBaseDir() + FolderConstants.getSpringFolder(); 
		if (this.isPlugin()) {
			apsSpringPath = apsSpringPath + "plugins" + File.separator + this.getPluginName() + File.separator;
		} else {
			apsSpringPath = apsSpringPath + this.getProjectName() + File.separator;	
		}
		apsSpringPath = apsSpringPath + "aps" + File.separator + "managers" + File.separator;

		return apsSpringPath;
	}

	/**
	 * 
	 * @return  .../src/main/resources/spring/whatever/apsadmin/
	 */
	public  String getSpringControllerConfigFolder() {
		String apsSpringPath = this.getBaseDir() + FolderConstants.getSpringFolder(); 
		if (this.isPlugin()) {
			apsSpringPath = apsSpringPath + "plugins" + File.separator + this.getPluginName() + File.separator;
		} else {
			apsSpringPath = apsSpringPath + this.getProjectName() + File.separator;	
		}
		apsSpringPath = apsSpringPath + "apsadmin" + File.separator;
		return apsSpringPath;
	}

	/**
	 * 
	 * @param forTest
	 * @return  .../src/main|test/resources/sql/whatever/
	 */
	public String getEntandoComponentSqlFolder(boolean forTest) {
		String componentPath = null;
		if (!forTest) {
			componentPath = this.getBaseDir() + FolderConstants.getSqlFolder();			
		} else {
			componentPath = this.getBaseDir() + FolderConstants.getSqlTestFolder();
		}

		if (this.isPlugin()) {
			componentPath = componentPath + "plugins" + File.separator + this.getPluginName();
		} else {			
			componentPath = componentPath + "misc" + File.separator + this.getProjectName();
		}
		componentPath = componentPath + File.separator;
		return componentPath;
	}

	/**
	 * 
	 * @return .../WEB-INF/whatever/
	 */

	public String getWebinfApsFolder() {
		String folder = this.getBaseDir() + FolderConstants.getWebInfFolder();
		if (this.isPlugin()) {
			folder = folder + "plugins" + File.separator + this.getPluginName() + File.separator;	
		}
        folder = folder + File.separator + "aps" + File.separator;
        //folder = folder + this.getProjectName() + File.separator + "aps" + File.separator;
		return folder;	
	}

    public String getWebinfApsFolderInternalServlet() {
        String folder = this.getBaseDir() + FolderConstants.getWebInfFolder();
        if (this.isPlugin()) {
            folder = folder + "plugins" + File.separator + this.getPluginName() + File.separator;
        }
        //folder = folder + File.separator + "aps" + File.separator;
        folder = folder + this.getProjectName() + File.separator + "aps" + File.separator;
        return folder;
    }

	public String getWebinfApsadminFolder() {
		String folder = this.getBaseDir() + FolderConstants.getWebInfFolder();
		if (this.isPlugin()) {
			folder = folder + "plugins" + File.separator + this.getPluginName() + File.separator;
		} else {
			folder = folder + this.getProjectName() + File.separator;	
		}
		folder = folder + "apsadmin" + File.separator;
		return folder;	
	}
	




	public String getPackageName() {
		return _packageName;
	}
	public void setPackageName(String packageName) {
		this._packageName = packageName;
	}

	public String getBaseDir() {
		return _baseDir;
	}
	public void setBaseDir(String baseDir) {
		this._baseDir = baseDir;
	}

	public String getPermission() {
		return _permission;
	}
	public void setPermission(String permission) {
		this._permission = permission;
	}

	public String getOriginalArgs() {
		return _originalArgs;
	}
	public void setOriginalArgs(String originalArgs) {
		this._originalArgs = originalArgs;
	}

	public List<EdoBean> getBeans() {
		return _beans;
	}
	public void setBeans(List<EdoBean> beans) {
		this._beans = beans;
	}

	private String _packageName;
	private String _baseDir = System.getProperty("user.dir");
	private String _permission = "superuser";
	private String _originalArgs = null;
	private List<EdoBean> _beans = new ArrayList<EdoBean>();
}
