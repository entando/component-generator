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
