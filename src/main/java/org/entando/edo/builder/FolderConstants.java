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
