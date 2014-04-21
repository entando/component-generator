/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps;


import com.myportal.SandboxConfigTestUtils;

import com.agiletec.ConfigTestUtils;
import com.agiletec.aps.BaseTestCase;

public class SandboxBaseTestCase extends BaseTestCase {

	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new SandboxConfigTestUtils();
	}

	
}
