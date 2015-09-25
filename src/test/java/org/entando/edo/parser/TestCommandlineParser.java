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

import java.io.File;

import org.entando.edo.Edo;
import org.entando.edo.mock.parser.MockCommandLineParser;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TestCommandlineParser  {

	@Test
	public void testTest1() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person id:primary_key name:string surname:string-r20");
		commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
		EdoBean bean = edoBuilder.getBean();
		
		Assert.assertNotNull(bean);
		Assert.assertEquals("Person", bean.getName());
		Assert.assertEquals("com.entando.plugins.jpacme", edoBuilder.getPackageName());
		Assert.assertEquals(3, bean.getFields().size());
		
		Assert.assertTrue(edoBuilder.isPlugin());
	}

	@Test
	public void testTest2() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		//commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
		EdoBean bean = edoBuilder.getBean();

		Assert.assertNotNull(bean);
	}

	@Test
	public void testTest3() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		//commandline.setBeanExpression("Person name:string surname:string-r20");
		//commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertNull("should be null", edoBuilder);
		
	}
	

	@Test
	public void testPom() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setCheckForPom(true);
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		//commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertNull("should be null", edoBuilder);
		
	}
	
	@Test
	public void testTest() throws Throwable {
		//Edo main = new Edo();
		Edo.main(null);
		
	}

}
