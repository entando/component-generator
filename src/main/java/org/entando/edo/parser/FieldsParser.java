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
package org.entando.edo.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entando.edo.datatype.DataTypeManager;
import org.entando.edo.model.EdoBean;
import org.entando.edo.model.EdoField;


public class FieldsParser implements IAgrumentParser {

	private static Logger _logger = LogManager.getLogger(FieldsParser.class);

	public String[] parse(EdoBean edoBean, String[] args) throws Exception {
		_logger.trace("input params: {}", Arrays.toString(args));
		List<EdoField> fieldsList = new ArrayList<EdoField>();
		List<String> fieldNames = new ArrayList<String>();
		int index = 0;
		for (int i = 0;  i < args.length; i++) {
			String param = args[i];
			if (this.isFieldArg(param)) {
				index = i;
				_logger.trace("the param: '{}' has a valid pattern", param);
				if (this.isValidField(param)) {
					_logger.trace("the field {} is valid field", param);
					EdoField edoField = new EdoField();
					String[] p = param.split(":");
					String fieldName = p[0];
					String fieldType = p[1];
					String fieldDataType = StringUtils.substringBefore(fieldType, "-").toLowerCase();
					String fieldFlags = StringUtils.substringAfter(fieldType, "-");
					edoField.setName(fieldName);
					edoField.setType(DataTypeManager.getInstance().getDataTypes().get(fieldDataType));
					
					if (i > 0 && fieldDataType.equalsIgnoreCase(DataTypeManager.TYPE_PRIMARY_KEY)) {
						throw new Exception("error parsing fields: the primary key must be the first field");
					}
					
					if (i == 0) {
						if (fieldDataType.equalsIgnoreCase(DataTypeManager.TYPE_PRIMARY_KEY)) {
							edoField.setRequired(true);
							edoField.setPrimaryKey(true);							
						} else {
							this.addDefaulPkFileld(fieldsList, fieldNames);
						}
					}
					
					edoField.setRequired(fieldFlags.contains("r"));
					
					
					Pattern pattern = Pattern.compile("(\\D*)(\\d+)(\\D*)");
					Matcher matcher = pattern.matcher(fieldFlags);
					if (matcher.matches()) {
						if (!edoField.getType().getJavaType().equals("String")) {
							_logger.warn("length option is valid only for string fields! -- skipping...");
						} else {
							String len = matcher.group(2);
							if (StringUtils.isNumeric(len)) {
								edoField.setLength(new Integer(len));
							}
						}
					}
					if (fieldsList.isEmpty() && edoField.getType().getJavaType().equals("BigDecimal")) {
						throw new Exception("BigDecimal cannot be used as primary key");
					}
					if (!fieldNames.contains(edoField.getName())) {
						fieldsList.add(edoField);
						fieldNames.add(edoField.getName());
						_logger.debug("added field with name '{}' and type {} ", edoField.getName(), edoField.getType().getJavaType());
					} else {
						_logger.error("field '{}' is already present", edoField.getName());
						if (edoField.getName().equalsIgnoreCase("id") && fieldsList.get(0).getType().equals(DataTypeManager.getInstance().getDataTypes().get("primary_key"))) {
							_logger.error("remember that if you do not specify a field of type :primary_key, an implicit field id:int is autamatically generated as primary key");							
						}
						throw new Exception("error parsing fields");						
					}
				} else {
					_logger.error("'{}' is not a valid field", param);
					throw new Exception("error parsing fields");
				}
			} else {
				_logger.debug("the param '{}' is not valid", param);
				throw new Exception("invalid param: " + param);
				//break;
			}
		}
		edoBean.setFields(fieldsList);
		String[] result = args;
		if (args.length>=index+1) {
			result = Arrays.copyOfRange(args, index+1, args.length);
		}
		return result;
	}

	protected void addDefaulPkFileld(List<EdoField> fieldsList,	List<String> fieldNames) {
		EdoField defaultPK = new EdoField();
		defaultPK.setRequired(true);
		defaultPK.setPrimaryKey(true);
		defaultPK.setName("id");
		defaultPK.setType(DataTypeManager.getInstance().getDataTypes().get("primary_key"));
		fieldsList.add(defaultPK);
		fieldNames.add(defaultPK.getName());
	}
	
	public boolean isFieldArg(String var) {
		Pattern pattern = Pattern.compile("(\\w*:\\w*)(-r(\\d*)?|-\\d*(r)?)*");
		Matcher matcher = pattern.matcher(var);
		return matcher.matches();
	}

	public boolean isValidField(String var) {
		String[] p = var.split(":");
		String fieldName = p[0];
		String fieldArgs = p[1];
		if (null == fieldName || fieldName.isEmpty()){
			_logger.warn("fieldName is null in {}", var);
			return false;
		}
		if (null == fieldArgs || fieldArgs.isEmpty()){
			_logger.warn("fieldType is null in {}", var);
			return false;
		}
		String fieldDataType = StringUtils.substringBefore(fieldArgs, "-").toLowerCase();
		return DataTypeManager.getInstance().getDataTypes().containsKey(fieldDataType);
	}
	

}
