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
package org.entando.edo.parser;

import org.entando.edo.parser.NameParser;

import junit.framework.TestCase;

public class TestNameParser extends TestCase {

	public void testNameParam() throws Exception {
		NameParser nameParser = new NameParser();
		String args = "xxx";
		boolean bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "xxx.yyy";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);
		
		args = "1Xxx";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "xxx-";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "xXX";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "xxx";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);
		args = "Xxx";
		bool = nameParser.checkClassName(args);
		assertTrue(bool);

		args = "XxxYxx";
		bool = nameParser.checkClassName(args);
		assertTrue(bool);

		args = "Xxx-Yxx";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "Xxx1Yxx";
		bool = nameParser.checkClassName(args);
		assertTrue(bool);

		args = "Xxx1 Yxx";
		bool = nameParser.checkClassName(args);
		assertFalse(bool);

		args = "Xxx1Yxx0";
		bool = nameParser.checkClassName(args);
		assertTrue(bool);

	}
}
