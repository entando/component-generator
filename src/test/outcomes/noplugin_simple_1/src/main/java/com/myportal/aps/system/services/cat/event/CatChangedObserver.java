/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services.cat.event;

import com.agiletec.aps.system.common.notify.ObserverService;

public interface CatChangedObserver extends ObserverService {
	
	public void updateFromCatChanged(CatChangedEvent event);
	
}
