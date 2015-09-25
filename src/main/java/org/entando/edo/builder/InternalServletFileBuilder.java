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
package org.entando.edo.builder;

import java.io.File;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;

public class InternalServletFileBuilder {

	public static Logger logger = LogManager.getLogger(InternalServletFileBuilder.class);


	
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
		String folder = bean.getEdoBuilder().getWebinfApsFolder();
		String subfolder = "jsp/internalservlet/".replaceAll("/", Matcher.quoteReplacement(File.separator));
		folder = folder + subfolder;
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

