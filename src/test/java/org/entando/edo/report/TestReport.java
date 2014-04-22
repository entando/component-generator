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
