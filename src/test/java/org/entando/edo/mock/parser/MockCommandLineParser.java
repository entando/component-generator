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