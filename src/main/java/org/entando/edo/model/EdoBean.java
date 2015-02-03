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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


public class EdoBean {
	
	public boolean buildWidgets() {
		return true;
	}

	public boolean buildApi() {
		return true;
	}
	
	public String getImports(boolean extras) {
		Set<String> imports = new HashSet<String>();
		Iterator<EdoField> it = this.getFields().iterator();
		while (it.hasNext()) {
			EdoField f = it.next();
			String importString = f.getType().getImportString();
			if (null != importString) {
				imports.add(importString);
			}
			if (extras) {
				String extraImportString = f.getType().getExtraImportString();
				if (null != extraImportString) {
					imports.add(extraImportString);
				}
			}
		}
		StringBuffer sbBuffer = new StringBuffer();
		Iterator<String> it2 = imports.iterator();
		while (it2.hasNext()) {
			if (sbBuffer.length() > 0) sbBuffer.append(System.getProperty("line.separator"));
			sbBuffer.append(it2.next());
		}
		return sbBuffer.toString();
		
	}
	
	public String getTableName() {
		String name = this.getName().toLowerCase();
		if (this.getEdoBuilder().isPlugin()) {
			String pname = StringUtils.substringAfter(this.getEdoBuilder().getPackageName(), ".plugins.");
			name = pname.split("\\.")[0] + "_" + name;
		}
		return name;
	}
	
	public boolean needsActionStrutsConversionProperties() {
		boolean x = false;
		Iterator<EdoField> it = this.getFields().iterator();
		while (it.hasNext()) {
			EdoField field = it.next();
			if (StringUtils.isNotEmpty(field.getType().getStrutsConversionProperties())) {
				x = true;
				break;
			}
		}
		return x;
	}

	public boolean needsFinderActionStrutsConversionProperties() {
		boolean x = false;
		Iterator<EdoField> it = this.getSearchFields().iterator();
		while (it.hasNext()) {
			EdoField field = it.next();
			if (StringUtils.isNotEmpty(field.getType().getStrutsConversionProperties())) {
				x = true;
				break;
			}
		}
		return x;
	}

	public boolean needsStrutsActionValidation() {
		boolean x = false;
		Iterator<EdoField> it = this.getFields().iterator();
		while (it.hasNext()) {
			EdoField field = it.next();
			if (!field.isPrimaryKey() && field.isRequired() ) {
				x = true;
				break;
			}
		}
		return x;
	}

	public boolean isEntandoSearcherAvailable() {
		boolean apply = false;
		if (null == this.getFields() || this.getFields().isEmpty()) return false;
		apply = this.getFields().get(0).getType().getJavaType().equals("String") ||
				this.getFields().get(0).getType().getJavaType().equals("BigDecimal") ||
				//add more fields...  ||
				this.getFields().get(0).getType().getJavaType().equals("int");
		return apply;
	}

	public List<EdoField> getSearchFields() {
		List<EdoField> searchFields = new ArrayList<EdoField>();
		Iterator<EdoField> it = this.getFields().iterator();
		while (it.hasNext()) {
			EdoField current = it.next();
			if (current.getType().getJavaTypeGeneric().equals("Date")) {
				EdoField start = current.clone();
				start.setName(start.getName() + "Start");
				
				EdoField end = current.clone();
				end.setName(end.getName() + "End");
				searchFields.add(start);
				searchFields.add(end);
			} else {
				searchFields.add(current);
			}
		}
		return searchFields;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	
	public List<EdoField> getFields() {
		return _fields;
	}
	public void setFields(List<EdoField> fields) {
		this._fields = fields;
	}

	public EdoBuilder getEdoBuilder() {
		return _edoBuilder;
	}
	public void setEdoBuilder(EdoBuilder edoBuilder) {
		this._edoBuilder = edoBuilder;
	}

	private String _name;
	private List<EdoField> _fields = new ArrayList<EdoField>();
	private EdoBuilder _edoBuilder;
}
