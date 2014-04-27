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
package org.entando.edo.model;

import java.io.File;

import org.entando.edo.mock.parser.MockCommandLineParser;
import org.junit.Assert;
import org.junit.Test;


public class TestEdoBean {
	
	
	@Test
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
