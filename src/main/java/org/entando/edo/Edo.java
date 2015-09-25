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
package org.entando.edo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.builder.Builder;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoBuilder;
import org.entando.edo.parser.CommandlineParser;

public class Edo {

	public static Logger logger = LogManager.getLogger(Edo.class);

	public static void main(String[] args) {
		try {
			CommandlineParser commandlineParser = new CommandlineParser();
			EdoBuilder edoBuilder = commandlineParser.generate(args);
			if (null == edoBuilder) return;
			EdoBean edoBean = edoBuilder.getBean();
			if (null == edoBean) return; 

			logger.info("Start process...");
			Builder b = new Builder();
			b.build(edoBuilder);
			logger.info("Done");

		} catch (Throwable t) {
			logger.error("Error", t);
		}
	}
}
