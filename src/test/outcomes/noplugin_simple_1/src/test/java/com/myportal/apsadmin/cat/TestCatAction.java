/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.apsadmin.cat;

import java.util.HashMap;
import java.util.Map;
import com.myportal.apsadmin.SandboxApsAdminBaseTestCase;
import com.opensymphony.xwork2.Action;

public class TestCatAction extends SandboxApsAdminBaseTestCase {

	public void testNew() throws Throwable {
		//TODO complete test
		Map<String, String> params = new HashMap<String, String>();
		String result = this.executeAction("new", params);
		assertEquals(Action.SUCCESS, result);
	}
	
	public void testEdit() throws Throwable {
		//TODO complete test
		Map<String, String> params = new HashMap<String, String>();
		String result = this.executeAction("edit", params);
		assertEquals(Action.INPUT, result);
	}
	
	public void testSave() throws Throwable {
		//TODO complete test
		Map<String, String> params = new HashMap<String, String>();
		String result = this.executeAction("save", params);
		assertEquals(Action.INPUT, result);
	}
	
	public void testTrash() throws Throwable {
		//TODO complete test
		Map<String, String> params = new HashMap<String, String>();
		String result = this.executeAction("trash", params);
		assertEquals(Action.INPUT, result);
	}
	
	public void testDelete() throws Throwable {
		//TODO complete test
		Map<String, String> params = new HashMap<String, String>();
		String result = this.executeAction("delete", params);
		assertEquals(Action.SUCCESS, result);
	}
	
	
	private String executeAction(String action, Map<String, String> params) throws Throwable {
		this.setUserOnSession("admin");
		this.initAction(NS, action);
		if (null != params) {
			this.addParameters(params);
		}
		String result = this.executeAction();
		return result;
	}

	private static final String NS = "/do/sandbox/Cat";

}
