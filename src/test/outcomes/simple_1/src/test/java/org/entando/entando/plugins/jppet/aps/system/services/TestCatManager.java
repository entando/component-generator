/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services;

import org.entando.entando.plugins.jppet.aps.JppetBaseTestCase;
import org.entando.entando.plugins.jppet.aps.system.services.cat.ICatManager;

public class TestCatManager extends JppetBaseTestCase {

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
		this._catManager = (ICatManager) this.getService("jppetCatManager");
	}
	
	private ICatManager _catManager;
}

