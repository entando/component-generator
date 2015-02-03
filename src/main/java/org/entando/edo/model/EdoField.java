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
package org.entando.edo.model;

import org.entando.edo.datatype.AbstractDataType;

public class EdoField {

	//private static final Logger _logger = LogManager.getLogger(EdoField.class);
	
	public EdoField clone() {
		EdoField clone = new EdoField();
		clone.setLength(this._length);
		clone.setName(this.name);
		clone.setRequired(this._required);
		clone.setType(this.type);
		return clone;
	}
	
	@Override
	public String toString() {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("name:").append(this.getName());
		sbBuffer.append(" ");
		sbBuffer.append("type:").append(this.getType().getClass().getName());
		sbBuffer.append(" ");
		sbBuffer.append("required:").append(this.isRequired());
		sbBuffer.append(" ");
		sbBuffer.append("length:").append(this.getLength());
		return sbBuffer.toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public AbstractDataType getType() {
		return type;
	}
	public void setType(AbstractDataType type) {
		this.type = type;
	}

	public boolean isRequired() {
		return _required;
	}
	public void setRequired(boolean required) {
		this._required = required;
	}

	public Integer getLength() {
		return _length;
	}
	public void setLength(Integer length) {
		this._length = length;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	private String name;
	private AbstractDataType type;
	private boolean _required;
	private Integer _length;
	private boolean primaryKey = false;

}
