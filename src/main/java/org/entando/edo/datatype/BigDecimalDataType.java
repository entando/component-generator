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


public class BigDecimalDataType extends AbstractDataType {

	@Override
	public String getJavaTypeGeneric() {
		return "BigDecimal";
	}

	@Override
	public String getJavaType() {
		return "BigDecimal";
	}

	@Override
	public String getImportString() {
		 return "import java.math.BigDecimal;";
	}

	@Override
	public String getStrutsConversionProperties() {
		return null;
	}

	@Override
	public String getExtraImportString() {
		return null;
	}

}
