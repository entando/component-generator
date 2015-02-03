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
package org.entando.edo;

import org.entando.edo.Edo;

import junit.framework.TestCase;

public class TestEdo extends TestCase {


	public void testForReal() {
		String inString = "-baseDir=/tmp/aaaa --package=com.myportal Cat name:string-r8 age:int weight:bigdecimal createdat:date";
		String[] args = inString.split(" ");
		Edo.main(args);
		assertTrue(true);
	}

	
}
