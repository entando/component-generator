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
package org.entando.edo.builder;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.model.EdoBean;


public class ServiceFileBuilder {

    public Logger logger = LogManager.getLogger(getClass());


    public static String getServiceInterfaceFilePath(EdoBean bean) {
        String filename = String.format("I%sService.java", bean.getName());
        String finalfile = ServiceFileBuilder.getServiceFolder(bean) + filename;
        return finalfile;
    }

    public static String getServiceFilePath(EdoBean bean) {
        String filename = String.format("%sService.java", bean.getName());
        String finalfile = ServiceFileBuilder.getServiceFolder(bean) + filename;
        return finalfile;
    }

    public static String getDtoFilePath(EdoBean bean) {
        String filename = bean.getName() + "Dto.java";
        String finalfile = ServiceFileBuilder.getDtoFolder(bean) + filename;
        return finalfile;
    }

    public static String getDtoRequestFilePath(EdoBean bean) {
        String filename = bean.getName() + "Request.java";
        String finalfile = ServiceFileBuilder.getJavaRestFolder(bean) + filename;
        return finalfile;
    }

    private static String getJavaRestFolder(EdoBean bean) {
        return bean.getEdoBuilder().getJavaFolder() + "web" + File.separator + bean.getName().toLowerCase() + File.separator + "model" + File.separator;
    }

    protected static String getServiceFolder(EdoBean bean) {
        String folder = bean.getEdoBuilder().getJavaServicesFolder() + bean.getName().toLowerCase() + File.separator;
        return folder;
    }
	
    protected static String getDtoFolder(EdoBean edoBean) {
        String folder = getServiceFolder(edoBean) + "model" + File.separator;
        return folder;
    }

	
}
