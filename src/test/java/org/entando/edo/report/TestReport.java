/*
 * Copyright 2013-Present Entando Corporation (http://www.entando.com) All rights reserved.
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
package org.entando.edo.report;

import java.lang.reflect.Field;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestReport  {

    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field instance = Report.class.getDeclaredField("obj");
       instance.setAccessible(true);
       instance.set(null, null);
    }
	
	@Test
	public void testReport() throws Exception {
		Report report = Report.getInstance();
		report.addFile("10");
		report.addFile("20");
		report.addFileToMerge("a");
		Report report2 = Report.getInstance();
		Assert.assertEquals(report, report2);
		report2.addFile("30");
		report2.addFileToMerge("b");
		report2.addFileToMerge("c");
		Report report3 = Report.getInstance();
		Assert.assertEquals(report3, report2);
		Assert.assertEquals(3, report3.getFiles().size());
		Assert.assertEquals(3, report3.getFilesToMerge().size());
	}
	
}
