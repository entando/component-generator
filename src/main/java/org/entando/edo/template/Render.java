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
