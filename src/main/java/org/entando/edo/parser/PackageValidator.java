/*
 * Copyright 2013-Present Entando Corporation (http://www.entando.com) All rights reserved.
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
package org.entando.edo.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class PackageValidator {

	public static boolean isValidPackageName(String packageArg) {
		
		if (StringUtils.isBlank(packageArg)) return false;
		
		Pattern pattern = Pattern.compile("([a-z]\\w*)(\\.[a-z][a-z]*)*");
		Matcher matcher = pattern.matcher(packageArg);
		return matcher.matches();
	}
}
