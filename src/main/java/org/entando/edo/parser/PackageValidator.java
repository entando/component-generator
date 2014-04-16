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
