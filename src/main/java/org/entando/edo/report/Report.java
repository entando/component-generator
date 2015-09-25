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
package org.entando.edo.report;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.management.InstanceAlreadyExistsException;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.StringUtils;

public class Report implements Serializable  {

	private Report() throws InstanceAlreadyExistsException {
		if(obj != null) {
			System.out.println("\nObject already created....");
			throw new InstanceAlreadyExistsException();
		}
	}

	public static Report getInstance() throws InstanceAlreadyExistsException {
		if(obj == null){
			synchronized (Report.class) {
				if(obj == null){
					obj = new Report();
				}
			}
		}
		return obj;
	}

	@Override
	protected Report clone() throws CloneNotSupportedException {
		// If user tries to clone the object then we are sending same class object
		try {
			return Report.getInstance();
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	private Object readResolve() throws ObjectStreamException, InstanceAlreadyExistsException {
		// We are blocking deserilizing object and sending same class object
		return Report.getInstance();
	}
	
	public void addFile(String file) {
		if (StringUtils.isNotBlank(file)) {
			this._files.add(new ReportFileInfo(file, 0));
		}
	}
	public void addFile(String file, int lines) {
		if (StringUtils.isNotBlank(file)) {
			this._files.add(new ReportFileInfo(file, lines));
		}
	}

	public void addFileToMerge(String file) {
		if (StringUtils.isNotBlank(file)) {
			this._filesToMerge.add(new ReportFileInfo(file, 0));
		}
	}

	public void addFileToMerge(String file, int lines) {
		if (StringUtils.isNotBlank(file)) {
			this._filesToMerge.add(new ReportFileInfo(file, lines));
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportFileInfo> getSortedFiles() {
		List<ReportFileInfo> list = new ArrayList<ReportFileInfo>();
		list.addAll(this._files);
		Collections.sort(list, new BeanComparator("path"));
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<ReportFileInfo> getSortedFilesToMerge() {
		List<ReportFileInfo> list = new ArrayList<ReportFileInfo>();
		list.addAll(this._filesToMerge);
		Collections.sort(list, new BeanComparator("path"));
		return list;
	}

	
	public List<ReportFileInfo> getFiles() {
		return _files;
	}
	public void setFiles(List<ReportFileInfo> files) {
		this._files = files;
	}

	public List<ReportFileInfo> getFilesToMerge() {
		return _filesToMerge;
	}
	public void setFilesToMerge(List<ReportFileInfo> filesToMerge) {
		this._filesToMerge = filesToMerge;
	}

	private static Report obj = null;
	private List<ReportFileInfo> _files = new ArrayList<ReportFileInfo>();
	private List<ReportFileInfo> _filesToMerge = new ArrayList<ReportFileInfo>();
}