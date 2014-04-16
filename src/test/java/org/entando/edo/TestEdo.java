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
package org.entando.edo;

import org.entando.edo.Edo;

import junit.framework.TestCase;

public class TestEdo extends TestCase {


	public void testForReal() {
		String inString = "-baseDir=/tmp/portal410 Task descr:string-r10 status:int";
		String[] args = inString.split(" ");
		Edo.main(args);
		assertTrue(true);
	}

	
}
