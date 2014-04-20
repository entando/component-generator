/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps;


import org.entando.entando.plugins.jppet.JppetConfigTestUtils;

import com.agiletec.ConfigTestUtils;
import com.agiletec.aps.BaseTestCase;

public class JppetBaseTestCase extends BaseTestCase {

	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new JppetConfigTestUtils();
	}

	
}
