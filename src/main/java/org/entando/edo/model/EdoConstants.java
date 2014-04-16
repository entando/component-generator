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
package org.entando.edo.model;

import org.apache.commons.lang.StringUtils;

/**
 * Template helper 
 *
 */
public  class EdoConstants {

	public static String getLowerCase(String s) {
		return s.toLowerCase();
	}

	public static String getCapitalize(String s) {
		return StringUtils.capitalize(s);
	}

	public static String getUnCapitalize(String s) {
		return StringUtils.uncapitalize(s);
	}

	public static String toUpperCase(String s) {
		return s.toUpperCase();
	}

	/**
	 * aps
	 * @return
	 */
	public static String getApsPackage() {
		return "aps";
	}
	
	/**
	 * 
	 * @return aps.system.services
	 */
	public static String getServicesPackage() {
		return "aps.system.services";
	}
	
	public static String getApsadminPackage() {
		 return "apsadmin";
	}

	/**
	 * aps.system.init.servdb
	 * @return
	 */
	public static String getInitPackage() {
		return "aps.system.init.servdb";
	}

	public static final String FILE_NO_OVERRIDE_PREFIX = "change_me-";
	
}
