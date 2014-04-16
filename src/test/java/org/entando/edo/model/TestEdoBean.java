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

import junit.framework.TestCase;

import org.entando.edo.parser.CommandlineParser;


public class TestEdoBean extends TestCase {

	public void test1() throws Throwable {
		CommandlineParser parser = new CommandlineParser();

		String args = "Person name:string surname:string-r20";
		EdoBean bean = parser.generate(args.split(" "));
		
		assertNotNull(bean);
		assertTrue(bean.isEntandoSearcherAvailable());
		
		
	}
	
	
	public void testSpringPrepositionForPlugin() {
		EdoBean scaffoldBean = new EdoBean();
		scaffoldBean.setPackageName("com.entando.plugins.jpacme");
		assertEquals("jpacme", scaffoldBean.getSpringBeanPreposition());
		assertTrue(scaffoldBean.isPlugin());
		assertEquals("jpacme", scaffoldBean.getPluginName());
	}

	public void testSpringPreposition1() {
		EdoBean scaffoldBean = new EdoBean();
		scaffoldBean.setPackageName("com.agiletec.xxx");
		assertEquals("edo", scaffoldBean.getSpringBeanPreposition());
		assertFalse(scaffoldBean.isPlugin());
	}

	public void testSpringPreposition2() {
		EdoBean scaffoldBean = new EdoBean();
		scaffoldBean.setPackageName("org.acme");
		assertEquals("edo", scaffoldBean.getSpringBeanPreposition());
		assertFalse(scaffoldBean.isPlugin());
		assertNull(scaffoldBean.getPluginName());
	}

	public void testTableNameForPlugin() {
		EdoBean scaffoldBean = new EdoBean();
		scaffoldBean.setPackageName("com.entando.plugins.jpacme");
		scaffoldBean.setName("Foo");
		assertEquals("jpacme_foo", scaffoldBean.getTableName());
		assertTrue(scaffoldBean.isPlugin());
	}
	
	public void testTableName1() {
		EdoBean scaffoldBean = new EdoBean();
		scaffoldBean.setPackageName("com.agiletec.xxx");
		scaffoldBean.setName("Foo");
		assertEquals("foo", scaffoldBean.getTableName());
		assertFalse(scaffoldBean.isPlugin());
	}

}
