/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal;

import org.apache.commons.lang.ArrayUtils;

import com.agiletec.ConfigTestUtils;

public class SandboxConfigTestUtils extends ConfigTestUtils {

	@Override
	protected String[] getSpringConfigFilePaths() {
		String[] baseFiles = super.getSpringConfigFilePaths();
		
		//TODO EDIT THIS
		String[] filePaths = new String[2];
		filePaths[0] = "classpath*:spring/sandbox/aps/**/**.xml ";
		filePaths[1] = "classpath*:spring/sandbox/**/**.xml";
		String[] newFiles = (String[]) ArrayUtils.addAll(baseFiles, filePaths);
		return newFiles;
    }
}


