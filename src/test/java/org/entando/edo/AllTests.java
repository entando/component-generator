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
package org.entando.edo;

import org.entando.edo.builder.TestControllerFileBuilder;
import org.entando.edo.builder.TestFileBuilder;
import org.entando.edo.model.TestEdoBean;
import org.entando.edo.parser.TestCommandlineParser;
import org.entando.edo.parser.TestFieldsParser;
import org.entando.edo.parser.TestNameParser;
import org.entando.edo.parser.TestPackageValidator;
import org.entando.edo.report.TestReport;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestControllerFileBuilder.class,
	TestFileBuilder.class,
	
	TestEdoBean.class,
	
	TestCommandlineParser.class,
	TestFieldsParser.class,
	TestNameParser.class,
	TestPackageValidator.class,
	
	TestReport.class
	
})
public class AllTests {

}
