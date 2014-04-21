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
package org.entando.edo.builder;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.entando.edo.builder.Filebuilder;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoConstants;


public class TestFileBuilder extends TestCase {
/*
	public void testGetPojoDirPlugin_1() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getPojoFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoDirPlugin_2() {
		//String workingDir = System.getProperty("user.dir");

		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("org.entando.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getPojoFilePath(bean);

		String expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/aps/system/services/pinkfloyd/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoDirCustom_1() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.demo");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getPojoFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/demo/aps/system/services/pinkfloyd/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoDirCustom_2() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.dunno");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getPojoFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/dunno/aps/system/services/pinkfloyd/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetDaoFiles() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getDaoInterfaceFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/IPinkFloydDAO.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = Filebuilder.getDaoImplFilePath(bean);
		expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/PinkFloydDAO.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetManagerFiles() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getManagerInterfaceFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/IPinkFloydManager.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = Filebuilder.getManagerImplFilePath(bean);
		expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/PinkFloydManager.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetEventFiles() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEventFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/event/PinkFloydChangedEvent.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = Filebuilder.getObserverFilePath(bean);
		expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/services/pinkfloyd/event/PinkFloydChangedObserver.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}


	public void testGetSpringManagerFilePathForPlugin() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getSpringManagerFilePath(bean);
		String expectedPath = "/src/main/resources/spring/plugins/jpacme/aps/managers/jpacmePinkFloydManagersConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetSpringManagerFilePathForCustom_1() {
		//String workingDir = System.getProperty("user.dir");
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.dunno");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getSpringManagerFilePath(bean);
		String expectedPath = "/src/main/resources/spring/sandbox/aps/managers/sandboxPinkFloydManagersConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetSpringManagerFilePathForCustom_2() {
		//String workingDir = System.getProperty("user.dir");
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("org.entando.entando.xxx.yyy.zzz");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getSpringManagerFilePath(bean);
		String expectedPath = "/src/main/resources/spring/sandbox/aps/managers/sandboxPinkFloydManagersConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}


	public void testGetPojoInitDirPlugin_1() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoPojoInitFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/aps/system/init/servdb/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoInitDirPlugin_2() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("org.entando.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoPojoInitFilePath(bean);

		String expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/aps/system/init/servdb/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoInitDirCustom_1() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.demo");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoPojoInitFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/demo/aps/system/init/servdb/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetPojoInitDirCustom_2() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.dunno");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoPojoInitFilePath(bean);

		String expectedPath = "/src/main/java/com/entando/dunno/aps/system/init/servdb/PinkFloyd.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//-------------
	public void testGetEntandoComponentFilePath_1() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoComponentFilePath(bean);

		String expectedPath = "/src/main/resources/component/plugins/jpacme/component.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentFilePath(bean);
			expectedPath = "/src/main/resources/component/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "component.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}

	}

	public void testGetEntandoComponentFilePath_2() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("org.entando.entando.plugins.jpacme");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoComponentFilePath(bean);

		String expectedPath = "/src/main/resources/component/plugins/jpacme/component.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentFilePath(bean);
			expectedPath = "/src/main/resources/component/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "component.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}

	public void testGetEntandoComponentFilePathCustom_1() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.demo");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoComponentFilePath(bean);

		String expectedPath = "/src/main/resources/component/sandbox/component.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentFilePath(bean);
			expectedPath = "/src/main/resources/component/sandbox/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "component.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}

	public void testGetEntandoComponentFilePathCustom_2() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.dunno");
		bean.setName("PinkFloyd");
		String path = Filebuilder.getEntandoComponentFilePath(bean);

		String expectedPath = "/src/main/resources/component/sandbox/component.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentFilePath(bean);
			expectedPath = "/src/main/resources/component/sandbox/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "component.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}

	public void testEntandoComponentSqlProductionFilePath_1() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.plugins.jpacme");
		bean.setName("PinkFloyd");

		String path = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
		String expectedPath = "/src/main/resources/sql/plugins/jpacme/serv_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
			expectedPath = "/src/main/resources/sql/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "serv_data_production.sql";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}


		path = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
		expectedPath = "/src/main/resources/sql/plugins/jpacme/port_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		filePath = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
		file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
			expectedPath = "/src/main/resources/sql/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "port_data_production.sql";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}

	public void testEntandoComponentSqlProductionFilePath_2() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("org.entando.entando.plugins.jpacme");
		bean.setName("PinkFloyd");

		String path = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
		String expectedPath = "/src/main/resources/sql/plugins/jpacme/serv_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		String filePath = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
			expectedPath = "/src/main/resources/sql/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "serv_data_production.sql";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}


		path = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
		expectedPath = "/src/main/resources/sql/plugins/jpacme/port_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		filePath = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
		file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			path = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
			expectedPath = "/src/main/resources/sql/plugins/jpacme/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "port_data_production.sql";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}


	public void testEntandoComponentSqlProductionFilePathCustom_1() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setPackageName("com.entando.demo");
		bean.setName("PinkFloyd");

		String path = Filebuilder.getEntandoComponentSqlServProductionFilePath(bean);
		String expectedPath = "/src/main/resources/sql/misc/sandbox_pinkfloyd/serv_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = Filebuilder.getEntandoComponentSqlPortProductionFilePath(bean);
		expectedPath = "/src/main/resources/sql/misc/sandbox_pinkfloyd/port_data_production.sql";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}
*/

}
