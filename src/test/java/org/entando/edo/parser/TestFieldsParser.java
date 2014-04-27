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

import junit.framework.Assert;

import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoField;
import org.junit.Test;


public class TestFieldsParser {

	@Test
	public void parseSimple() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string somedate:date cash:bigDecimal-1";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(4, bean.getFields().size());
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			EdoField f = bean.getFields().get(i);
			Assert.assertNotNull(f);
			Assert.assertNotNull(f.getType());
		}
		
		Assert.assertNull(bean.getFields().get(2).getLength());
		Assert.assertEquals(false, bean.getFields().get(2).isRequired());
		Assert.assertEquals(false, bean.getFields().get(1).isRequired());
		Assert.assertEquals(true, bean.getFields().get(0).isRequired());
		
		Assert.assertTrue(bean.isBuildApi());
		Assert.assertTrue(bean.isBuildWidgets());
	}
	

 
	@Test
	public void parseRequired() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string somedate:date-r";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(3, bean.getFields().size());
		
		Assert.assertNull(bean.getFields().get(2).getLength());
		Assert.assertEquals(true, bean.getFields().get(2).isRequired());

		for (int i = 0; i < bean.getFields().size(); i++) {
			//System.out.println(bean.getFields().get(i));
		}
	}

	@Test
	public void parseLength() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string somedate:date-r100 pippo:string-20";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(4, bean.getFields().size());
		
		Assert.assertNull(bean.getFields().get(2).getLength());
		Assert.assertEquals(true, bean.getFields().get(2).isRequired());
		
		Assert.assertEquals(20, bean.getFields().get(3).getLength().intValue());
		Assert.assertEquals(false, bean.getFields().get(3).isRequired());
		
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			//System.out.println(bean.getFields().get(i));
		}
	}
	
	@Test
	public void parseLength2() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string pippo:string-100r";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(3, bean.getFields().size());
		
		Assert.assertEquals(100, bean.getFields().get(2).getLength().intValue());
		Assert.assertEquals(true, bean.getFields().get(2).isRequired());
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			//System.out.println(bean.getFields().get(i));
		}
	}
	
	@Test
	public void parseLength3() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string pippo:string-r100";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(3, bean.getFields().size());
		Assert.assertEquals(100, bean.getFields().get(2).getLength().intValue());
		Assert.assertEquals(true, bean.getFields().get(2).isRequired());
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			//System.out.println(bean.getFields().get(i));
		}
	}

	@Test
	public void parseLength4() throws Throwable {
		EdoBean bean = new EdoBean();

		String params = "id:primary_key name:string";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(2, bean.getFields().size());
		Assert.assertNull(bean.getFields().get(1).getLength());
		Assert.assertEquals(false, bean.getFields().get(1).isRequired());

		params = "id:primary_key name:string-8";
		parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(2, bean.getFields().size());
		Assert.assertEquals(8, bean.getFields().get(1).getLength().intValue());
		Assert.assertEquals(false, bean.getFields().get(1).isRequired());

		params = "id:primary_key name:string-8r";
		parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(2, bean.getFields().size());
		Assert.assertEquals(8, bean.getFields().get(1).getLength().intValue());
		Assert.assertEquals(true, bean.getFields().get(1).isRequired());

		params = "id:primary_key name:string-r8";
		parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(2, bean.getFields().size());
		Assert.assertEquals(8, bean.getFields().get(1).getLength().intValue());
		Assert.assertEquals(true, bean.getFields().get(1).isRequired());
	}
	
	
	@Test(expected = Exception.class)
	public void primaryKeyWrongInput_1() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "id:primary_key name:string wrong:primary_key";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
	
	}

	@Test(expected = Exception.class)
	public void primaryKeyWrongInput_2() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "name:string wrong:primary_key";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
	}

	
	@Test
	public void parseWithOptions_1() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "--skipAPI name:string somedate:date cash:bigDecimal-1";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(4, bean.getFields().size());
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			EdoField f = bean.getFields().get(i);
			Assert.assertNotNull(f);
			Assert.assertNotNull(f.getType());
		}
		
		Assert.assertNull(bean.getFields().get(2).getLength());
		Assert.assertEquals(false, bean.getFields().get(2).isRequired());
		Assert.assertEquals(false, bean.getFields().get(1).isRequired());
		Assert.assertEquals(true, bean.getFields().get(0).isRequired());
		
		Assert.assertFalse(bean.isBuildApi());
		Assert.assertTrue(bean.isBuildWidgets());
	}

	@Test
	public void parseWithOptions_2() throws Throwable {
		EdoBean bean = new EdoBean();
		String params = "--skipWidgets --skipAPI name:string somedate:date cash:bigDecimal-1";
		FieldsParser parser = new FieldsParser();
		parser.parse(bean, params.split(" "));
		Assert.assertEquals(4, bean.getFields().size());
		
		for (int i = 0; i < bean.getFields().size(); i++) {
			EdoField f = bean.getFields().get(i);
			Assert.assertNotNull(f);
			Assert.assertNotNull(f.getType());
		}
		
		Assert.assertNull(bean.getFields().get(2).getLength());
		Assert.assertEquals(false, bean.getFields().get(2).isRequired());
		Assert.assertEquals(false, bean.getFields().get(1).isRequired());
		Assert.assertEquals(true, bean.getFields().get(0).isRequired());
		
		Assert.assertFalse(bean.isBuildApi());
		Assert.assertFalse(bean.isBuildWidgets());
	}
	
}
