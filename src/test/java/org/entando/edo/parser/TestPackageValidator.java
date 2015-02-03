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

import junit.framework.TestCase;

public class TestPackageValidator extends TestCase {

	public void testPackageParam() throws Exception {
		String args = "xxx";
		boolean bool = PackageValidator.isValidPackageName(args);
		assertTrue(bool);

		args = "xxx.yyy";
		bool = PackageValidator.isValidPackageName(args);
		assertTrue(bool);
		
		args = "Xxx.yyy";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);

		args = "xxx.Yyy";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);

		args = "xXX.yYY";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);

		args = "xxx.";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);
		args = "xxx.yyy.";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);

		args = "xxx.yyy.XXXX.xx";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);

		args = "org.entando.entando.plugins.jpZZZZoOOObie";
		bool = PackageValidator.isValidPackageName(args);
		assertFalse(bool);
		
		
		
	}
}
