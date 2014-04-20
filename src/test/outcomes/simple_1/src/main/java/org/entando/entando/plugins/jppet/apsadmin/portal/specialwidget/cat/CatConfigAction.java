/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.apsadmin.portal.specialwidget.cat;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.apsadmin.portal.specialwidget.SimpleWidgetConfigAction;
import org.entando.entando.plugins.jppet.aps.system.services.cat.ICatManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatConfigAction extends SimpleWidgetConfigAction {

	private static final Logger _logger =  LoggerFactory.getLogger(CatConfigAction.class);
	
	protected String extractInitConfig() {
		String result = super.extractInitConfig();
		String id = this.getWidget().getConfig().getProperty("id");
		if (StringUtils.isNotBlank(id)) {
			this.setId(new Integer(id));
		}
		return result;
	}

	public List<Integer> getCatsId() {
		try {
			List<Integer> cats = this.getCatManager().searchCats(null);
			return cats;
		} catch (Throwable t) {
			_logger.error("error in getCatsId", t);
			throw new RuntimeException("Error getting cats list", t);
		}
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	protected ICatManager getCatManager() {
		return _catManager;
	}
	public void setCatManager(ICatManager catManager) {
		this._catManager = catManager;
	}

	private int _id;
	private ICatManager _catManager;
}

