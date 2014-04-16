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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;

public class InternalServletFileBuilder {

	public static Logger logger = LogManager.getLogger(ControllerFileBuilder.class);

	private static String getActionDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getApsFolder() + File.separator + "internalservlet" + File.separator + bean.getName().toLowerCase() + File.separator;
		return pojoPath;
	}
	
	private static String getJspDir(EdoBean bean) {
		String pojoPath = bean.getBaseDir() + FolderConstants.getWebInfFolder();
		if (bean.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + File.separator;	
		}
		pojoPath = pojoPath + FolderConstants.getInternalServletJspFolder();
		return pojoPath;
	}
	
	
	public static String getInternalServletXmlFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "Front.xml";
		String finalfile = InternalServletFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getInternalServletActionFilePath(EdoBean bean) {
		String filename = bean.getName() + "FrontEndAction.java";
		String finalfile = InternalServletFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getInternalServletFinderActionFilePath(EdoBean bean) {
		String filename = bean.getName() + "FinderFrontEndAction.java";
		String finalfile = InternalServletFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	
	public static String getInternalServletJspFilePath(EdoBean bean, String suffix) {
		String filename = "frontend-"+StringUtils.uncapitalize(bean.getName()) + suffix;
		String finalfile = InternalServletFileBuilder.getJspDir(bean) + bean.getName().toLowerCase() + File.separator + filename;
		return finalfile;
	}
	
	public static String getInternalServletJspListFilePath(EdoBean bean) {
		return getInternalServletJspFilePath(bean, "-list.jsp");
	}

	public static String getInternalServletJspEntryFilePath(EdoBean bean) {
		return getInternalServletJspFilePath(bean, "-entry.jsp");
	}

	public static String getInternalServletJspTrashFilePath(EdoBean bean) {
		return getInternalServletJspFilePath(bean, "-trash.jsp");
	}

	public static String getInternalServletJspErrorFilePath(EdoBean bean) {
		return getInternalServletJspFilePath(bean, "-error.jsp");
	}
	
	
}

