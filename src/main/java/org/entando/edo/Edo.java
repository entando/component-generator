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
