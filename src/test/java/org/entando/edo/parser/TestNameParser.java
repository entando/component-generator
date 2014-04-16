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
