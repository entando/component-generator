/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat.event;

import com.agiletec.aps.system.common.notify.ObserverService;

public interface CatChangedObserver extends ObserverService {
	
	public void updateFromCatChanged(CatChangedEvent event);
	
}
