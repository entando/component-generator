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

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;


public class NameParser implements IAgrumentParser {

	private static Logger _logger = LogManager.getLogger(NameParser.class);

	public String[] parse(EdoBean edoBean, String[] args) throws Exception {
		_logger.trace("input params: {}", Arrays.toString(args));
		String nameArg = args[0];

		boolean checkName = this.checkClassName(nameArg);
		if (checkName) {
			edoBean.setName(nameArg);
			_logger.info("bean name is: '{}'", edoBean.getName());
		} else {
			_logger.error("invalid class name: '{}'", args[0]);
			throw new Exception("invalid class name '" + args[0] + "'");
		}
		return Arrays.copyOfRange(args, 1, args.length);
	}

	public boolean checkClassName(String arg) {
		Pattern pattern = Pattern.compile("([A-Z])([\\w]*)*");
		Matcher matcher = pattern.matcher(arg);
		return matcher.matches();
	}

}

