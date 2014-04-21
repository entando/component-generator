/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services.cat.event;

import com.agiletec.aps.system.common.IManager;
import com.agiletec.aps.system.common.notify.ApsEvent;
import com.myportal.aps.system.services.cat.Cat;


public class CatChangedEvent extends ApsEvent {
	
	@Override
	public void notify(IManager srv) {
		((CatChangedObserver) srv).updateFromCatChanged(this);
	}
	
	@Override
	public Class getObserverInterface() {
		return CatChangedObserver.class;
	}
	
	public int getOperationCode() {
		return _operationCode;
	}
	public void setOperationCode(int operationCode) {
		this._operationCode = operationCode;
	}
	
	public Cat getCat() {
		return _cat;
	}
	public void setCat(Cat cat) {
		this._cat = cat;
	}

	private Cat _cat;
	private int _operationCode;
	
	public static final int INSERT_OPERATION_CODE = 1;
	public static final int REMOVE_OPERATION_CODE = 2;
	public static final int UPDATE_OPERATION_CODE = 3;

}
