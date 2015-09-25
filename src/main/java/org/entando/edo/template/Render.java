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
package org.entando.edo.template;

import java.io.StringWriter;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class Render {

	public static Logger logger = LogManager.getLogger(Render.class);

	public String render(String templateFileName, Map<String, Object> contextElements) throws Throwable {
		String render = null;
		try {
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute" );
			ve.setProperty("runtime.log.logsystem.log4j.logger", "root" );

			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
			ve.init();

			Template t = ve.getTemplate(templateFileName);

			VelocityContext velocityContext = new VelocityContext();
			if (null != contextElements && !contextElements.isEmpty()) {
				for (Map.Entry<String, Object> entry : contextElements.entrySet()) {
					velocityContext.put(entry.getKey(), entry.getValue());
				}
			}
			StringWriter stringWriter = new StringWriter();

			t.merge(velocityContext, stringWriter);


			stringWriter.flush();
			render = stringWriter.toString();
		} catch (Throwable t) {
			logger.error("error rendering template {}", templateFileName, t);
			throw t;
		}
		return render;
	}
	
}
