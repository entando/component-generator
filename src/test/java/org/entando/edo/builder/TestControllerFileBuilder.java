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
import org.entando.edo.builder.ControllerFileBuilder;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoConstants;



public class TestControllerFileBuilder extends TestCase {

	public void testGetActionFilePath_Plugin() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getActionFilePath(bean);
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetActionFilePath_Custom() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.demo");
		String path = ControllerFileBuilder.getActionFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/PinkFloydAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionFilePath(bean);
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/PinkFloydAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetFinderActionFilePath_Plugin() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getFinderActionFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydFinderAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getFinderActionFilePath(bean);
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydFinderAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	public void testGetFinderActionFilePath_Custom() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.demo");
		String path = ControllerFileBuilder.getFinderActionFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/PinkFloydFinderAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getFinderActionFilePath(bean);
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/PinkFloydFinderAction.java";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetActionXmlFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionXmlFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/pinkFloyd.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getActionXmlFilePath(bean);
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/pinkFloyd.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionXmlFilePath(bean);
		expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/pinkFloyd.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionXmlFilePath(bean);
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/pinkFloyd.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetPackageFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getPackageFilePath(bean, "it");
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/package_it.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getPackageFilePath(bean, "en");
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/package_en.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getPackageFilePath(bean, "it");
		expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/package_it.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getPackageFilePath(bean, "en");
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/package_en.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetActionValidationXmlFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionValidationXmlFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction-validation.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getActionValidationXmlFilePath(bean);
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction-validation.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionValidationXmlFilePath(bean);
		expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/PinkFloydAction-validation.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionValidationXmlFilePath(bean);
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/PinkFloydAction-validation.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetActionConversionFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionConversionFilePath(bean);
		String expectedPath = "/src/main/java/com/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction-conversion.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getActionConversionFilePath(bean);
		expectedPath = "/src/main/java/org/entando/entando/plugins/jpacme/apsadmin/pinkfloyd/PinkFloydAction-conversion.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionConversionFilePath(bean);
		expectedPath = "/src/main/java/com/entando/demo/apsadmin/pinkfloyd/PinkFloydAction-conversion.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionConversionFilePath(bean);
		expectedPath = "/src/main/java/com/entando/dunno/apsadmin/pinkfloyd/PinkFloydAction-conversion.properties";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
	}

	//----------------------------------------

	public void testGetTilesFilePath() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionTilesFilePath(bean);
		String expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jpacme-tiles.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("org.entando.entando.plugins.jpacme");
		path = ControllerFileBuilder.getActionTilesFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jpacme-tiles.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionTilesFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/sandbox-tiles.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionTilesFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/sandbox-tiles.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		String filePath = ControllerFileBuilder.getActionTilesFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			

			bean.setPackageName("com.entando.dunno");
			path = ControllerFileBuilder.getActionTilesFilePath(bean);
			expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "sandbox-tiles.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}


	public void testGetActionSpringFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionSpringFilePath(bean);
		String expectedPath = "/src/main/resources/spring/plugins/jpacme/apsadmin/jpacmePinkFloydActionsConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionSpringFilePath(bean);
		expectedPath = "/src/main/resources/spring/sandbox/apsadmin/sandboxPinkFloydActionsConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionSpringFilePath(bean);
		expectedPath = "/src/main/resources/spring/sandbox/apsadmin/sandboxPinkFloydActionsConfig.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

	}

	//STRUTS_PLUGIN

	public void testGetActionStrutsPluginFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionStrutsPluginFilePath(bean);
		String expectedPath = "/src/main/resources/entando-struts-plugin.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionStrutsPluginFilePath(bean);
		expectedPath = "/src/main/resources/entando-struts-plugin.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionStrutsPluginFilePath(bean);
		expectedPath = "/src/main/resources/entando-struts-plugin.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

	}

	// ------------SHORTCUTS

	public void testGetActionShortCutFilePath() throws IOException {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getActionShortCutFilePath(bean);
		String expectedPath = "/src/main/resources/shortcuts/plugins/jpacme/apsadmin/shortcuts.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.demo");
		path = ControllerFileBuilder.getActionShortCutFilePath(bean);
		expectedPath = "/src/main/resources/shortcuts/apsadmin/shortcuts.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("com.entando.dunno");
		path = ControllerFileBuilder.getActionShortCutFilePath(bean);
		expectedPath = "/src/main/resources/shortcuts/apsadmin/shortcuts.xml";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);


		String filePath = ControllerFileBuilder.getActionShortCutFilePath(bean);
		File file = new File(filePath);
		try {
			String text = "This is a text file";
			FileUtils.writeStringToFile(file, text, "UTF-8");
			

			bean.setPackageName("com.entando.dunno");
			path = ControllerFileBuilder.getActionShortCutFilePath(bean);
			expectedPath = "/src/main/resources/shortcuts/apsadmin/" + EdoConstants.FILE_NO_OVERRIDE_PREFIX + "shortcuts.xml";
			expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
			assertEquals(expectedPath , path);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.forceDelete(file);
		}
	}

	//-----------jsp

	public void testGetJspFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");

		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getJspListFilePath(bean);
		String expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-list.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-entry.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-trash.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		//---
		bean.setPackageName("com.entando.demo");

		path = ControllerFileBuilder.getJspListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-list.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-entry.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-trash.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		//---
		bean.setPackageName("com.entando.dunno");

		path = ControllerFileBuilder.getJspListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-list.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-entry.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/pinkfloyd/pinkFloyd-trash.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		bean.setPackageName("org.entando.entando.plugins.jpacme");

		path = ControllerFileBuilder.getJspListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-list.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-entry.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

		path = ControllerFileBuilder.getJspTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/pinkfloyd/pinkFloyd-trash.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);

	}
	
	//-- jsp extras
	
	public void testGetJspExtrasFilePath() {
		EdoBean bean = new EdoBean();
		bean.setBaseDir(bean.getBaseDir() + File.separator + "target" + File.separator + "sandbox"); 
		bean.setName("PinkFloyd");
		
		bean.setPackageName("com.entando.plugins.jpacme");
		String path = ControllerFileBuilder.getJspExtraResourcesListFilePath(bean);
		String expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-list-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-entry-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-trash-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		//---
		bean.setPackageName("com.entando.demo");
		
		path = ControllerFileBuilder.getJspExtraResourcesListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-list-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-entry-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-trash-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		//---
		bean.setPackageName("com.entando.dunno");
		
		path = ControllerFileBuilder.getJspExtraResourcesListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-list-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-entry-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/sandbox/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-trash-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		
		
		bean.setPackageName("org.entando.entando.plugins.jpacme");
		
		path = ControllerFileBuilder.getJspExtraResourcesListFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-list-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesEntryFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-entry-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
		path = ControllerFileBuilder.getJspExtraResourcesTrashFilePath(bean);
		expectedPath = "/src/main/webapp/WEB-INF/plugins/jpacme/apsadmin/jsp/common/layouts/assets-more/pinkFloyd-trash-extras.jsp";
		expectedPath = (bean.getBaseDir() + expectedPath).replaceAll("/", Matcher.quoteReplacement(File.separator));
		assertEquals(expectedPath , path);
		
	}

}
