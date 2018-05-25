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
package org.entando.edo.mock.parser;

import org.apache.commons.lang.StringUtils;
import org.entando.edo.model.EdoBuilder;
import org.entando.edo.parser.CommandlineParser;

public class MockCommandLineParser extends CommandlineParser {
	
	public MockCommandLineParser() {
		super.setCheckForPom(false);
	}

	public EdoBuilder generate() throws Throwable {
		return this.generate(this.getArgs());
	}

    //    protected EdoInput processFile(CommandLine cl) {
    //
    //        EdoInput edoInput = new EdoInput();
    //        edoInput.setBaseDir(this.getBaseDir());
    //        edoInput.setPackageName(this.getPackageName());
    //        edoInput.setPermission(this.getp);
    //
    //        try {
    //            if (cl.hasOption(OPTION_EDO_FILE)) {
    //                String filePath = cl.getOptionValue(OPTION_EDO_FILE);
    //                if (StringUtils.isBlank(filePath)) {
    //                    _logger.error("invalid path specifed");
    //                    throw new IllegalArgumentException("invalid path specifed");
    //                }
    //
    //                ObjectMapper mapper = new ObjectMapper();
    //                Path path = Paths.get(filePath);
    //                EdoInput input = mapper.readValue(new File(path.toUri()), EdoInput.class);
    //                return input;
    //            } else {
    //                _logger.error("no input file specified");
    //                throw new EdoInputException("no input file specified");
    //            }
    //        } catch (IOException e) {
    //            _logger.error("error parsing input file", e);
    //            throw new EdoInputException("error parsing input file", e);
    //        }
    //    }

	public String[] getArgs() {
		return this.getOptions().split(" ");
	}

	public String getOptions() {
		StringBuffer sbBuffer = new StringBuffer();
		if (StringUtils.isNotBlank(this.getBaseDir())) {
			sbBuffer.append("--baseDir=").append(this.getBaseDir()).append(" ");
		}		
		if (StringUtils.isNotBlank(this.getPackageName())) {
			sbBuffer.append("--package=").append(this.getPackageName()).append(" ");
		}

		if (StringUtils.isNotBlank(this.getBeanExpression())) {
			sbBuffer.append(this.getBeanExpression());
		}
		return sbBuffer.toString();
	}

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getBaseDir() {
		return baseDir;
	}
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}


	public String getBeanExpression() {
		return beanExpression;
	}
	public void setBeanExpression(String beanExpression) {
		this.beanExpression = beanExpression;
	}


	private String packageName;
	private String baseDir;
	private String beanExpression;
}