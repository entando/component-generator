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

import org.apache.commons.lang.StringUtils;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoBuilder;

public class WidgetFileBuilder {

	private static String getApsadminJspFolder(EdoBean bean) {
		String folder = bean.getEdoBuilder().getWebinfApsadminFolder() + "jsp" + File.separator;
		return folder;
	}

	private static String getApsJspFolder(EdoBean bean) {
		String folder = bean.getEdoBuilder().getWebinfApsFolder() + "jsp" + File.separator;
		return folder;
	}
	
	private static String getSpecialWidgetActionDir(EdoBean bean) {
		String folder = bean.getEdoBuilder().getJavaControllerFolder()  + "portal" +  File.separator  + "specialwidget" + File.separator  + bean.getName().toLowerCase() + File.separator;
		return folder;
	}

	private static String getApsTagsActionDir(EdoBean bean) {
		String folder = bean.getEdoBuilder().getJavaFolder() + "aps" + File.separator + "tags" +  File.separator;
		return folder;
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
		String finalfile = getApsadminJspFolder(bean) + "portal" + File.separator + "specialwidget" + File.separator + bean.getName().toLowerCase() + File.separator +  filename;
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
		String folder = getApsJspFolder(bean);
		
		folder = folder + "widgets" + File.separator;

		String filename = "";
		if (bean.getEdoBuilder().isPlugin()) {
			filename = bean.getEdoBuilder().getPluginName();
		} 
		filename = filename + StringUtils.capitalize(bean.getName()) + ".jsp";
		String finalfile = folder + filename;

		return finalfile;
	}

	public static String getApsTldFilePath(EdoBuilder builder) {
		String filename = null;
		if (builder.isPlugin()) {
			filename = builder.getPluginName();
		} else {
			filename = builder.getProjectName();
		}
		filename = filename + "-core.tld";
		String path = builder.getTldFolder();
		String finalfile = Filebuilder.checkAndRenameFile(builder.getBaseDir(), path, filename);
		return finalfile;
	}

}
