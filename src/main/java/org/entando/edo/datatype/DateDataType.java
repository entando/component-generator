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
