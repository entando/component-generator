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
package org.entando.edo.datatype;

public class DateDataType extends AbstractDataType {

	@Override
	public String getJavaTypeGeneric() {
		return "Date";
	}

	@Override
	public String getJavaType() {
		return "Date";
	}

	@Override
	public String getImportString() {
		return "import java.util.Date;";
	}

	@Override
	public String getExtraImportString() {
		return "import java.sql.Timestamp;";
	}

	@Override
	public String getStrutsConversionProperties() {
		return "com.agiletec.apsadmin.system.conversion.ApsDateTypeConverter";
	}

	
}
