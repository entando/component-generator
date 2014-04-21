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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;

public class InternalServletFileBuilder {

	public static Logger logger = LogManager.getLogger(ControllerFileBuilder.class);

//	
//	private static String getJspDir(EdoBean bean) {
//
//		return pojoPath;
//	}
//	
	
	public static String getInternalServletXmlFilePath(EdoBean bean) {
		String folder = bean.getEdoBuilder().getJavaControllerInternalServletFolder() + StringUtils.uncapitalize(bean.getName()) +  File.separator;
		String filename = StringUtils.uncapitalize(bean.getName()) + "Front.xml";
		String finalfile = folder + filename;
		return finalfile;
	}

	public static String getInternalServletActionFilePath(EdoBean bean) {
		String folder = bean.getEdoBuilder().getJavaControllerInternalServletFolder() + StringUtils.uncapitalize(bean.getName()) +  File.separator;
		String filename = bean.getName() + "FrontEndAction.java";
		String finalfile = folder + filename;
		return finalfile;
	}

	public static String getInternalServletFinderActionFilePath(EdoBean bean) {
		String folder = bean.getEdoBuilder().getJavaControllerInternalServletFolder() + StringUtils.uncapitalize(bean.getName()) +  File.separator;
		String filename = bean.getName() + "FinderFrontEndAction.java";
		String finalfile = folder + filename;
		return finalfile;
	}

	
	public static String getInternalServletJspFilePath(EdoBean bean, String suffix) {
		String folder = bean.getEdoBuilder().getJspWidgetFolder();
		folder = folder + FolderConstants.getInternalServletJspFolder();
		folder = folder + bean.getName().toLowerCase() + File.separator;
		
		String filename = "frontend-"+StringUtils.uncapitalize(bean.getName()) + suffix;
		String finalfile = folder + filename;
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

