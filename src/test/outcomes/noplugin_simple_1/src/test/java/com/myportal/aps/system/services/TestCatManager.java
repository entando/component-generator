/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services;

import com.myportal.aps.SandboxBaseTestCase;
import com.myportal.aps.system.services.cat.ICatManager;

public class TestCatManager extends SandboxBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}
	
	public void testGetCat() {
		//TODO complete test
		assertNotNull(this._catManager);
	}

	public void testGetCats() {
		//TODO complete test
		assertNotNull(this._catManager);
	}
	
	public void testSearchCats() {
		//TODO complete test
		assertNotNull(this._catManager);
	}

	public void testAddCat() {
		//TODO complete test
		assertNotNull(this._catManager);
	}

	public void testUpdateCat() {
		//TODO complete test
		assertNotNull(this._catManager);
	}

	public void testDeleteCat() {
		//TODO complete test
		assertNotNull(this._catManager);
	}
	
	private void init() {
		//TODO add the spring bean id as constant
		this._catManager = (ICatManager) this.getService("sandboxCatManager");
	}
	
	private ICatManager _catManager;
}

