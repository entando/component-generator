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
		//String inString = "--baseDir=/home/spuddu/entando/github/sandbox411eedo --package=org.entando.entando.plugins.jppet Cat name:string-r8 age:int weight:bigdecimal createdat:date";
		String inString = "--baseDir=/home/spuddu/entando/github/sandbox411eedo --package=com.entando.entando.plugins.jppet Cat catid:primary_key name:string surname:string-r20 AND Dog --skipAPI name:string birthDate:date-r AND Penguin --skipAPI --skipWidgets age:int weight:bigdecimal";
		String[] args = inString.split(" ");
		Edo.main(args);
		assertTrue(true);
	}

	
}
