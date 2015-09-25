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

import org.entando.edo.model.EdoConstants;


public class FolderConstants {

	/**
	 * aps/system/services
	 * @return
	 */
	public static String getServicesFolder() {
		return EdoConstants.getServicesPackage().replaceAll("\\.", Matcher.quoteReplacement(File.separator));
	}

	
	/**
	 * aps/system/init/servdb
	 * @return
	 */
	public static String getInitFolder() {
		return EdoConstants.getInitPackage().replaceAll("\\.", Matcher.quoteReplacement(File.separator));
	}

	
	/**
	 * /src/main/java/
	 * @return
	 */
	public static String getJavaFolder() {
		return "/src/main/java/".replaceAll("/", Matcher.quoteReplacement(File.separator));
	}

	/**
	 * /src/test/java/
	 * @return
	 */
	public static String getJavaTestFolder() {
		return "/src/test/java/".replaceAll("/", Matcher.quoteReplacement(File.separator));
	}

	/**
	 * /src/main/webapp/WEB-INF/
	 * @return
	 */
	public static String getWebInfFolder() {
		return "/src/main/webapp/WEB-INF/".replaceAll("/", Matcher.quoteReplacement(File.separator));
	}

	/**
	 * /src/main/tld/
	 * @return
	 */
	public static String getTldFolder() {
		return "/src/main/tld/".replaceAll("/", Matcher.quoteReplacement(File.separator));
	}


	/**
	 * /src/main/resources/
	 * @return
	 */
	public static String getResourcesFolder() {
		return RESOURCES_FOLDER.replaceAll("/", Matcher.quoteReplacement(File.separator));
	}

	/**
	 * /src/main/resources/spring/
	 * @return
	 */
	public static String getSpringFolder() {
		return (RESOURCES_FOLDER + "spring/").replaceAll("/", Matcher.quoteReplacement(File.separator));
	}


	/**
	 * /src/main/resources/sql/
	 * @return
	 */
	public static String getSqlFolder() {
		return (RESOURCES_FOLDER + "sql/").replaceAll("/", Matcher.quoteReplacement(File.separator));
	}

	/**
	 * /src/test/resources/sql/
	 * @return
	 */
	public static String getSqlTestFolder() {
		return (RESOURCES_TEST_FOLDER + "sql/").replaceAll("/", Matcher.quoteReplacement(File.separator));
	}
	
	private static final String RESOURCES_FOLDER = "/src/main/resources/";
	private static final String RESOURCES_TEST_FOLDER = "/src/test/resources/";
	

}
