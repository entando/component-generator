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
		Assert.assertTrue(edoBuilder.isPlugin());
		Assert.assertEquals("org.entando.entando.plugins.jpperson", edoBuilder.getPackageName());
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
	public void testAND_1() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Cat catid:primary_key name:string surname:string-r20 AND Dog --skipAPI name:string AND Penguin --skipAPI --skipWidgets age:int");
		commandline.setPackageName("com.entando.plugins.jppet");
		EdoBuilder edoBuilder = commandline.generate();
		Assert.assertEquals("com.entando.plugins.jppet", edoBuilder.getPackageName());
		Assert.assertTrue(edoBuilder.isPlugin());
		
		Assert.assertEquals(3, edoBuilder.getBeans().size());
		EdoBean cat = edoBuilder.getBean("Cat");
		EdoBean dog = edoBuilder.getBean("Dog");
		EdoBean penguin = edoBuilder.getBean("Penguin");
		
		Assert.assertNotNull(cat);
		Assert.assertNotNull(dog);
		Assert.assertNotNull(penguin);
		Assert.assertEquals(3, cat.getFields().size());
		Assert.assertEquals(2, dog.getFields().size());
		Assert.assertEquals(2, penguin.getFields().size());

		Assert.assertTrue(cat.isBuildApi());
		Assert.assertTrue(cat.isBuildWidgets());

		Assert.assertFalse(dog.isBuildApi());
		Assert.assertTrue(dog.isBuildWidgets());

		Assert.assertFalse(penguin.isBuildApi());
		Assert.assertFalse(penguin.isBuildWidgets());

	}

	@Test(expected=Exception.class)
	public void testAND_WithErrors() throws Throwable {
		MockCommandLineParser commandline = new MockCommandLineParser();
		commandline.setBaseDir(System.getProperty("user.dir") + File.separator + "target" + File.separator + "sandbox");
		commandline.setBeanExpression("Cat catid:primary_key name:string surname:string-r20 AND Dog --skipAPI name:string and Penguin --skipAPI --skipWidgets age:int");
		commandline.setPackageName("com.entando.plugins.jppet");
		EdoBuilder edoBuilder = commandline.generate();
		Assert.assertEquals("com.entando.plugins.jppet", edoBuilder.getPackageName());
		Assert.assertTrue(edoBuilder.isPlugin());
		
		Assert.assertEquals(3, edoBuilder.getBeans().size());
		EdoBean cat = edoBuilder.getBean("Cat");
		EdoBean dog = edoBuilder.getBean("Dog");
		EdoBean penguin = edoBuilder.getBean("Penguin");
		
		Assert.assertNotNull(cat);
		Assert.assertNotNull(dog);
		Assert.assertNotNull(penguin);
		Assert.assertEquals(3, cat.getFields().size());
		Assert.assertEquals(2, dog.getFields().size());
		Assert.assertEquals(2, penguin.getFields().size());
		
		Assert.assertTrue(cat.isBuildApi());
		Assert.assertTrue(cat.isBuildWidgets());
		
		Assert.assertFalse(dog.isBuildApi());
		Assert.assertTrue(dog.isBuildWidgets());
		
		Assert.assertFalse(penguin.isBuildApi());
		Assert.assertFalse(penguin.isBuildWidgets());
		
	}
	
	
	
	@Test
	public void testTest() throws Throwable {
		//Edo main = new Edo();
		Edo.main(null);
		
	}

}
