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


public class Filebuilder {

	public static Logger logger = LogManager.getLogger(Filebuilder.class);
	
	private static String getPojoDir(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		
//		String x = workingDir + FolderConstants.getJavaFolder();
//		
//		x= x +   bean.getPackageName().replaceAll("\\.", File.separator) ;
//		
//		x = x + File.separator + FolderConstants.getServicesFolder()  ;
//		x= x + File.separator + bean.getName().toLowerCase() + File.separator;
		
		
		
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getServicesFolder() + File.separator + bean.getName().toLowerCase() + File.separator;
		return pojoPath;
	}
	
	public static String getPojoFilePath(EdoBean bean) {
		String filename = bean.getName() + ".java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}

	public static String getDaoInterfaceFilePath(EdoBean bean) {
		String filename = "I"+bean.getName() + "DAO.java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}

	public static String getDaoImplFilePath(EdoBean bean) {
		String filename = bean.getName() + "DAO.java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}

	public static String getDaoSearcherImplFilePath(EdoBean bean) {
		String filename = bean.getName() + "SearcherDAO.java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}

	public static String getManagerInterfaceFilePath(EdoBean bean) {
		String filename = "I"+bean.getName() + "Manager.java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}
	
	public static String getManagerImplFilePath(EdoBean bean) {
		String filename = bean.getName() + "Manager.java";
		String finalfile = Filebuilder.getPojoDir(bean) + filename;
		return finalfile;
	}
	
	//EVENT
	public static String getEventFilePath(EdoBean bean) {
		String filename = bean.getName() + "ChangedEvent.java";
		String finalfile = Filebuilder.getPojoDir(bean) + "event" + File.separator + filename;
		return finalfile;
	}

	public static String getObserverFilePath(EdoBean bean) {
		String filename = bean.getName() + "ChangedObserver.java";
		String finalfile = Filebuilder.getPojoDir(bean) + "event" + File.separator + filename;
		return finalfile;
	}
	
	//API bean
	public static String getApiBeanFilePath(EdoBean bean) {
		//TODO test
		String filename = "JAXB" + bean.getName() + ".java";
		String finalfile = Filebuilder.getPojoDir(bean)  + "api" + File.separator + filename;
		return finalfile;
	}
	public static String getApiResponseFilePath(EdoBean bean) {
		//TODO test
		String filename = bean.getName() + "Response.java";
		String finalfile = Filebuilder.getPojoDir(bean)  + "api" + File.separator + filename;
		return finalfile;
	}
	public static String getApiListResponseFilePath(EdoBean bean) {
		//TODO test
		String filename = bean.getName() + "ListResponse.java";
		String finalfile = Filebuilder.getPojoDir(bean)  + "api" + File.separator + filename;
		return finalfile;
	}
	
	public static String getApiResponseResultFilePath(EdoBean bean) {
		//TODO test
		String filename = bean.getName() + "ResponseResult.java";
		String finalfile = Filebuilder.getPojoDir(bean)  + "api" + File.separator + filename;
		return finalfile;
	}
	public static String getApiListResponseResultFilePath(EdoBean bean) {
		//TODO test
		String filename = bean.getName() + "ListResponseResult.java";
		String finalfile = Filebuilder.getPojoDir(bean)  + "api" + File.separator + filename;
		return finalfile;
	}


	public static String getApiFolderPath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String apiFolderPath = bean.getBaseDir() + FolderConstants.getApiFolder(); 
		if (bean.isPlugin()) {
			apiFolderPath = apiFolderPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			apiFolderPath = apiFolderPath + bean.getProjectName() + File.separator;	
		}
		apiFolderPath = apiFolderPath + "aps" + File.separator;
		return apiFolderPath;
	}
	
	public static String getApiMethodsFilePath(EdoBean bean) {
		String filename = "apiMethods.xml";
		String path = Filebuilder.getApiFolderPath(bean);
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), path, filename);
		return finalfile;
	}
	
	
	public static String getEntandoPojoInitFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String pojoPath = bean.getBaseDir() + FolderConstants.getJavaFolder() + bean.getPackageName().replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + File.separator + FolderConstants.getInitFolder() + File.separator;
		String filename = bean.getName() + ".java";
		String finalfile = pojoPath + filename;
		return finalfile;
	}
	
	//-------------
	
	public static String getSpringManagerFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String apsSpringPath = bean.getBaseDir() + FolderConstants.getSpringFolder(); 
		if (bean.isPlugin()) {
			apsSpringPath = apsSpringPath + "plugins" + File.separator + bean.getPluginName() + File.separator;
		} else {
			apsSpringPath = apsSpringPath + bean.getProjectName() + File.separator;	
		}
		apsSpringPath = apsSpringPath + "aps" + File.separator + "managers" + File.separator;
		
		String filename = bean.getSpringBeanPreposition() + bean.getName() + "ManagersConfig.xml";
		//String finalfile = apsSpringPath + filename;
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), apsSpringPath, filename);
		return finalfile;
	}

	public static String getEntandoComponentFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = bean.getBaseDir() + FolderConstants.getComponentFolder();

		if (bean.isPlugin()) {
			componentPath = componentPath + "plugins" + File.separator + bean.getPluginName();
		} else {			
			componentPath = componentPath + bean.getSpringBeanPreposition();
		}
		componentPath = componentPath + File.separator;
		String filename = "component.xml";
		
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), componentPath, filename);
		
		return finalfile;
	}

	
	private static String getEntandoComponentSqlFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = bean.getBaseDir() + FolderConstants.getSqlFolder();
		
		if (bean.isPlugin()) {
			componentPath = componentPath + "plugins" + File.separator + bean.getPluginName();
		} else {			
			componentPath = componentPath + "misc" + File.separator + bean.getProjectName() + "_" + bean.getName().toLowerCase();
		}
		componentPath = componentPath + File.separator;
		return componentPath;
	}

	private static String getEntandoComponentSqlTestFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = bean.getBaseDir() + FolderConstants.getSqlTestFolder();
		if (bean.isPlugin()) {
			componentPath = componentPath + "plugins" + File.separator + bean.getPluginName();
		} else {			
			componentPath = componentPath + "misc" + File.separator + bean.getProjectName() + "_" + bean.getName().toLowerCase();
		}
		componentPath = componentPath + File.separator;
		return componentPath;
	}

	public static String getEntandoComponentSqlServProductionFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = Filebuilder.getEntandoComponentSqlFilePath(bean);
		String filename = "serv_data_production.sql";
		//String finalfile = componentPath + filename;
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), componentPath, filename);
		return finalfile;
	}
	public static String getEntandoComponentSqlPortProductionFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = Filebuilder.getEntandoComponentSqlFilePath(bean);
		String filename = "port_data_production.sql";
		//String finalfile = componentPath + filename;
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), componentPath, filename);
		return finalfile;
	}
	
	public static String getEntandoComponentSqlServTestFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = Filebuilder.getEntandoComponentSqlTestFilePath(bean);
		String filename = "serv_data_test.sql";
		//String finalfile = componentPath + filename;
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), componentPath, filename);
		return finalfile;
	}
	
	public static String getEntandoComponentSqlPortTestFilePath(EdoBean bean) {
		//String workingDir = System.getProperty("user.dir");
		String componentPath = Filebuilder.getEntandoComponentSqlTestFilePath(bean);
		String filename = "port_data_test.sql";
		//String finalfile = componentPath + filename;
		String finalfile = Filebuilder.checkAndRenameFile(bean.getBaseDir(), componentPath, filename);
		return finalfile;
	}

	protected static String checkAndRenameFile(String workingDir, String path,	String name) {
		String finalfile = path + name;
		File f = new File(finalfile);
		if (f.exists()) {
			finalfile = path + EdoConstants.FILE_NO_OVERRIDE_PREFIX + name;
			logger.warn("\n\n*** Warning\nThe file:\n\n\t" + StringUtils.substringAfter(f.getAbsolutePath(), workingDir  + File.separator) + "\n\nexists and will not be overwritten.\nThe new one is:\n\n\t" + StringUtils.substringAfter(finalfile, workingDir + File.separator) + "\n\nmerge it by hand\n");
		}
		return finalfile;
	}

	
}
