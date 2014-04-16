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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataTypeManager implements Serializable  {

	private static Logger _logger = LogManager.getLogger(DataTypeManager.class);

	private DataTypeManager() {
		if(obj != null) {
			_logger.error("Object alreaty created");
		}
		this.init();
		_logger.trace("available datatypes: {}", this.getDataTypes().keySet().toString());
	}

	public static DataTypeManager getInstance() {
		if(obj == null){
			synchronized (DataTypeManager.class) {
				if(obj == null){
					obj = new DataTypeManager();
				}
			}
		}
		return obj;
	}

	@Override
	protected DataTypeManager clone() throws CloneNotSupportedException {
		return DataTypeManager.getInstance();
	}

	public void init() {
		this._dataTypes.put(TYPE_DATE, new DateDataType());
		this._dataTypes.put(TYPE_INT, new IntegerDataType());
		this._dataTypes.put(TYPE_STRING, new StringDataType());
		this._dataTypes.put(TYPE_BIG_DECIMAL, new BigDecimalDataType());
		this._dataTypes.put(TYPE_PRIMARY_KEY, new PrimaryKeyDataType());
	}

	public Map<String, AbstractDataType> getDataTypes() {
		return _dataTypes;
	}
	public void setDataTypes(Map<String, AbstractDataType> dataTypes) {
		this._dataTypes = dataTypes;
	}

	private Map<String, AbstractDataType> _dataTypes = new HashMap<String, AbstractDataType>();

	private static DataTypeManager obj = null;
	public static final String TYPE_INT = "int";
	public static final String TYPE_DATE = "date";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_BIG_DECIMAL = "bigdecimal";
	public static final String TYPE_PRIMARY_KEY = "primary_key";
}
