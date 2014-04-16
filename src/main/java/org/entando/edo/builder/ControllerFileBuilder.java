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
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoConstants;


public class ControllerFileBuilder {

	public static Logger logger = LogManager.getLogger(ControllerFileBuilder.class);

	private static String getActionBaseDir(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getApsadminFolder() + File.separator;
		return pojoPath;
	}
	
	private static String getActionDir(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String pojoPath = getActionBaseDir(bean) + bean.getName().toLowerCase() + File.separator;
		return pojoPath;
	}

	public static String getActionFilePath(EdoBean bean) {
		String filename = bean.getName() + "Action.java";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getFinderActionFilePath(EdoBean bean) {
		String filename = bean.getName() + "FinderAction.java";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getActionXmlFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + ".xml";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getPackageFilePath(EdoBean bean, String lang) {
		String filename = "package_" + lang + ".properties";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}
	
	public static String getActionValidationXmlFilePath(EdoBean bean) {
		String filename = bean.getName() + "Action-validation.xml";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getActionConversionFilePath(EdoBean bean) {
		String filename = bean.getName() + "Action-conversion.properties";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getActionFinderConversionFilePath(EdoBean bean) {
		String filename = bean.getName() + "FinderAction-conversion.properties";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}

	public static String getActionPropertiesFilePath(EdoBean bean,	String lang) {
		String filename = "package_" + lang + ".properties";
		String finalfile = ControllerFileBuilder.getActionDir(bean) + filename;
		return finalfile;
	}
	
	public static String getGlobalMessagesPropertiesFilePath(EdoBean bean,	String lang) {
		String filename = "global-messages_" + lang + ".properties";
		String finalfile = ControllerFileBuilder.getActionBaseDir(bean) + filename;
		return finalfile;
		

	}
	


	private static String getWebInfDir(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String pojoPath = bean.getBaseDir() + FolderConstants.getWebInfFolder();
		
		if (bean.isPlugin()) {
			pojoPath = pojoPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			pojoPath = pojoPath + bean.getProjectName() + File.separator;	
		}
		
		return pojoPath;
	}
	
	public static String getActionTilesFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String name = null;
		if (bean.isPlugin()) {
			name = bean.getPluginName();
		} else {
			name = bean.getProjectName();
		}
		String filename = name + "-tiles.xml";
		String finalpath  = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator;
		return checkAndRenameFile(bean.getBaseDir(), finalpath, filename);
	}

	//--- spring

	public static String getActionSpringFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String apsSpringPath = bean.getBaseDir() + FolderConstants.getSpringFolder(); 
		if (bean.isPlugin()) {
			apsSpringPath = apsSpringPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			apsSpringPath = apsSpringPath + bean.getProjectName() + File.separator;	
		}
		apsSpringPath = apsSpringPath + "apsadmin" + File.separator;
		
		String filename = bean.getSpringBeanPreposition() + bean.getName() + "ActionsConfig.xml";
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), apsSpringPath, filename);
		//String finalfile = apsSpringPath + filename;
		return finalfile;
	}
	
	//--- jsp
	
	public static String getJspListFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-list.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + bean.getName().toLowerCase() + File.separator +  filename;
		return finalfile;
	}
	public static String getJspEntryFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-entry.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + bean.getName().toLowerCase() + File.separator +  filename;
		return finalfile;
	}
	public static String getJspTrashFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-trash.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + bean.getName().toLowerCase() + File.separator +  filename;
		return finalfile;
	}

	public static String getJspExtraResourcesListFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-list-extras.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + "common" + File.separator + "layouts" + File.separator + "assets-more"  + File.separator +  filename;
		return finalfile;
	}
	public static String getJspExtraResourcesEntryFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-entry-extras.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + "common" + File.separator + "layouts" + File.separator + "assets-more"  + File.separator +  filename;
		return finalfile;
	}
	public static String getJspExtraResourcesTrashFilePath(EdoBean bean) {
		String filename = StringUtils.uncapitalize(bean.getName()) + "-trash-extras.jsp";
		String finalfile = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + "common" + File.separator + "layouts" + File.separator + "assets-more"  + File.separator +  filename;
		return finalfile;
	}

	public static String getJspSubMenuFilePath(EdoBean bean) {
		String filename = "subMenu.jsp";
		String path = ControllerFileBuilder.getWebInfDir(bean) + "apsadmin" + File.separator + "jsp" + File.separator + "common" + File.separator + "layouts"  + File.separator;
		String finalfile = checkAndRenameFile(bean.getBaseDir(), path, filename);
		return finalfile;
	}

	
	//----
	


	
	//---
	
	public static String getActionShortCutFilePath(EdoBean bean) {
		String apsSpringPath = bean.getBaseDir() + FolderConstants.getResourcesFolder() + "shortcuts" + File.separator; 
		if (bean.isPlugin()) {
			apsSpringPath = apsSpringPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			apsSpringPath = apsSpringPath ;//+ bean.getProjectName() + File.separator;	
		}
		apsSpringPath = apsSpringPath + "apsadmin" + File.separator;
	
		String filename = "shortcuts.xml";
		String finalfile = ControllerFileBuilder.checkAndRenameFile(bean.getBaseDir(), apsSpringPath, filename);
		return finalfile;
		
	}

	public static String getActionStrutsPluginFilePath(EdoBean bean) {
		
		boolean exists = new File(bean.getBaseDir() + FolderConstants.getResourcesFolder(), "entando-struts-plugin.xml").exists();
		String filename = null;
		String finalfile = null;
		if (!exists) {
			filename = "entando-struts-plugin.xml";
			finalfile = bean.getBaseDir() + FolderConstants.getResourcesFolder() + filename;
		} else {
			filename = EdoConstants.FILE_NO_OVERRIDE_PREFIX + bean.getSpringBeanPreposition() + "-" + bean.getName().toLowerCase() + "-struts-plugin.xml";
			finalfile = bean.getBaseDir() + FolderConstants.getResourcesFolder() + filename;
			logger.warn("\n\n*** Warning!\nThe file:\n\n\t" + StringUtils.substringAfter(finalfile, bean.getBaseDir()  + File.separator) + "\n\nneeds your attention!.\nPlease merge it with your existing {} or rename it according to your web.xml cofiguration.\n", bean.getBaseDir() + FolderConstants.getResourcesFolder() + "entando-struts-plugin");
		}
		

		return finalfile;
	}
	
	
	protected static String checkAndRenameFile(String workingDir, String path,	String name) {
		String finalfile = path + name;
		File f = new File(finalfile);
		if (f.exists()) {
			finalfile = path + EdoConstants.FILE_NO_OVERRIDE_PREFIX + name;
			logger.warn("\n\n*** Warning!\nThe file:\n\n\t" + StringUtils.substringAfter(f.getAbsolutePath(), workingDir  + File.separator) + "\n\nexists and will not be overwritten!.\nThe new one is:\n\n\t" + StringUtils.substringAfter(finalfile, workingDir + File.separator) + "\n\nmerge it by hand\n");
		}
		return finalfile;
	}


}
