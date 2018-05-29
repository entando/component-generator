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
package org.entando.edo.model;

import org.entando.edo.mock.parser.MockCommandLineParser;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;


public class TestEdoBean {
	
	
	@Test
	@Ignore
	public void testEntandoSearcherAvailable() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		EdoBuilder edoBuilder = commandline.generate();
		EdoBean bean = edoBuilder.getBean();
		
		Assert.assertNotNull(bean);
		Assert.assertTrue(bean.isEntandoSearcherAvailable());
	}
	
	
	@Test
	@Ignore
	public void testSpringPrepositionForPlugin() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertEquals("jpacme", edoBuilder.getSpringBeanPreposition());
		Assert.assertTrue(edoBuilder.isPlugin());
		Assert.assertEquals("jpacme", edoBuilder.getPluginName());
	}

	@Test
	@Ignore
	public void testSpringPreposition1() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		commandline.setPackageName("com.agiletec.xxx");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertEquals("sandbox", edoBuilder.getSpringBeanPreposition());
		Assert.assertFalse(edoBuilder.isPlugin());
	}

	@Test
	@Ignore
	public void testSpringPreposition2() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Person name:string surname:string-r20");
		commandline.setPackageName("org.acme");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertEquals("sandbox", edoBuilder.getSpringBeanPreposition());
		Assert.assertFalse(edoBuilder.isPlugin());
		Assert.assertNull(edoBuilder.getPluginName());
	}

	@Test
	@Ignore
	public void testTableNameForPlugin() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Foo custom_id:primary_key");
		commandline.setPackageName("com.entando.plugins.jpacme");
		EdoBuilder edoBuilder = commandline.generate();
	
		Assert.assertEquals("jpacme_foo", edoBuilder.getBean().getTableName());
		Assert.assertTrue(edoBuilder.isPlugin());
	}
	

	@Test
	@Ignore
	public void testTableName1() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Foo custom_id:primary_key");
		commandline.setPackageName("com.agiletec.xxx");
		EdoBuilder edoBuilder = commandline.generate();

		Assert.assertEquals("foo", edoBuilder.getBean().getTableName());
		Assert.assertFalse(edoBuilder.isPlugin());
	}

	@Test
	@Ignore
	public void testTableName2() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Foo");
		commandline.setPackageName("com.agiletec.xxx");
		EdoBuilder edoBuilder = commandline.generate();
		
		Assert.assertEquals("foo", edoBuilder.getBean().getTableName());
		Assert.assertFalse(edoBuilder.isPlugin());
	}

}
