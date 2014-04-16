/*
*
* Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
* This file is part of Entando Enterprise Edition software.
* You can redistribute it and/or modify it
* under the terms of the Entando's EULA
* 
* See the file License for the specific language governing permissions   
* and limitations under the License
* 
* 
* 
* Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
*/
package org.entando.edo.builder;

import java.io.File;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.entando.edo.model.EdoBean;

public class WidgetFileBuilder {


	private static String getSpecialWidgetActionDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getApsadminFolder() + File.separator + "portal" +  File.separator  + "specialwidget" + File.separator  + bean.getName().toLowerCase() + File.separator;
		return pojoPath;
	}


	private static String getWidgetsDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getWebInfFolder();
		if (bean.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + File.separator;	
		}
		pojoPath = pojoPath + FolderConstants.getWidgetFolder();
		return pojoPath;
	}


	private static String getTldDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getTldFolder();
		if (bean.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + bean.getProjectName() + File.separator;	
		}
		return pojoPath;
	}

	private static String getApsTagsActionDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getApsFolder() + File.separator + "tags" +  File.separator;
		return pojoPath;
	}

	public static String getSpecialWidgetActionFilePath(EdoBean bean) {
		String filename = StringUtils.capitalize(bean.getName()) + "ConfigAction.java";
		String finalfile = WidgetFileBuilder.getSpecialWidgetActionDir(bean) + filename;
		return finalfile;
	}

	public static String getSpecialWidgetActionPropertiesFilePath(EdoBean bean, String lang) {
		String filename = "package_" + lang + ".properties";
		String finalfile = WidgetFileBuilder.getSpecialWidgetActionDir(bean) + filename;
		return finalfile;
	}

	public static String getSpecialWidgetActionXmlFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "SpecialWidget.xml";
		String finalfile = WidgetFileBuilder.getSpecialWidgetActionDir(bean) + filename;
		return finalfile;
	}

	public static String getJspSpecialWidgetFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-config.jsp";
		String finalfile = WidgetFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + "portal" + File.separator + "specialwidget" + File.separator + bean.getName().toLowerCase() + File.separator +  filename;
		return finalfile;
	}

	public static String getTagListFilePath(EdoBean bean) {
		String filename = StringUtils.capitalize(bean.getName()) + "ListTag.java";
		String finalfile = WidgetFileBuilder.getApsTagsActionDir(bean) + filename;
		return finalfile;
	}

	public static String getTagSingleFilePath(EdoBean bean) {
		String filename = StringUtils.capitalize(bean.getName()) + "Tag.java";
		String finalfile = WidgetFileBuilder.getApsTagsActionDir(bean) + filename;
		return finalfile;
	}

	public static String getJspWidgetFilePath(EdoBean bean) {
		String filename = "";
		if (bean.isPlugin()) {
			filename = bean.getPluginName();
		} 
		filename = filename + StringUtils.capitalize(bean.getName()) + ".jsp";
		String finalfile = WidgetFileBuilder.getWidgetsDir(bean) + filename;

		return finalfile;
	}

	public static String getApsTldFilePath(EdoBean bean) {
		String filename = null;
		if (bean.isPlugin()) {
			filename = bean.getPluginName();
		} else {
			filename = bean.getProjectName();
		}
		filename = filename + "-core.tld";
		String path = WidgetFileBuilder.getTldDir(bean);
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), path, filename);
		return finalfile;
	}

	private static String getWebInfDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getWebInfFolder();
		
		if (bean.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + bean.getProjectName() + File.separator;	
		}
		
		return pojoPath;
	}

}
