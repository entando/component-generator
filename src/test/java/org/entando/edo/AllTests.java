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
package org.entando.edo;

import org.entando.edo.parser.TestFieldsParser;
import org.entando.edo.parser.TestNameParser;
import org.entando.edo.parser.TestPackageValidator;
import org.entando.edo.report.TestReport;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
                     //	TestBuilder.class,
                     //	TestBuilderNoPlugin.class,
                     //	TestEdoBean.class,
                     //TestCommandlineParser.class,
	TestFieldsParser.class,
	TestNameParser.class,
	TestPackageValidator.class,
	
	TestReport.class
	
})
public class AllTests {

}
