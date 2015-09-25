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
