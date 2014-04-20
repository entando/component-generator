/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.apsadmin.cat;

import org.entando.entando.plugins.jppet.aps.system.services.cat.Cat;
import org.entando.entando.plugins.jppet.aps.system.services.cat.ICatManager;

import java.util.Date;
import java.math.BigDecimal;

import com.agiletec.apsadmin.system.ApsAdminSystemConstants;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(CatAction.class);

	public String newCat() {
		try {
			this.setStrutsAction(ApsAdminSystemConstants.ADD);
		} catch (Throwable t) {
			_logger.error("error in newCat", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String edit() {
		try {
			Cat cat = this.getCatManager().getCat(this.getId());
			if (null == cat) {
				this.addActionError(this.getText("error.cat.null"));
				return INPUT;
			}
			this.populateForm(cat);
			this.setStrutsAction(ApsAdminSystemConstants.EDIT);
		} catch (Throwable t) {
			_logger.error("error in edit", t);
			return FAILURE;
		}
		return SUCCESS;
	}

	public String save() {
		try {
			Cat cat = this.createCat();
			int strutsAction = this.getStrutsAction();
			if (ApsAdminSystemConstants.ADD == strutsAction) {
				this.getCatManager().addCat(cat);
			} else if (ApsAdminSystemConstants.EDIT == strutsAction) {
				this.getCatManager().updateCat(cat);
			}
		} catch (Throwable t) {
			_logger.error("error in save", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String trash() {
		try {
			Cat cat = this.getCatManager().getCat(this.getId());
			if (null == cat) {
				this.addActionError(this.getText("error.cat.null"));
				return INPUT;
			}
			this.populateForm(cat);
			this.setStrutsAction(ApsAdminSystemConstants.DELETE);
		} catch (Throwable t) {
			_logger.error("error in trash", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String delete() {
		try {
			if (this.getStrutsAction() == ApsAdminSystemConstants.DELETE) {
				this.getCatManager().deleteCat(this.getId());
			}
		} catch (Throwable t) {
			_logger.error("error in delete", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String view() {
		try {
			Cat cat = this.getCatManager().getCat(this.getId());
			if (null == cat) {
				this.addActionError(this.getText("error.cat.null"));
				return INPUT;
			}
			this.populateForm(cat);
		} catch (Throwable t) {
			_logger.error("error in view", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	private void populateForm(Cat cat) throws Throwable {
		this.setId(cat.getId());
		this.setName(cat.getName());
		this.setAge(cat.getAge());
		this.setWeight(cat.getWeight());
		this.setCreatedat(cat.getCreatedat());
	}
	
	private Cat createCat() {
		Cat cat = new Cat();
		cat.setId(this.getId());
		cat.setName(this.getName());
		cat.setAge(this.getAge());
		cat.setWeight(this.getWeight());
		cat.setCreatedat(this.getCreatedat());
		return cat;
	}
	

	public int getStrutsAction() {
		return _strutsAction;
	}
	public void setStrutsAction(int strutsAction) {
		this._strutsAction = strutsAction;
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}

	public int getAge() {
		return _age;
	}
	public void setAge(int age) {
		this._age = age;
	}

	public BigDecimal getWeight() {
		return _weight;
	}
	public void setWeight(BigDecimal weight) {
		this._weight = weight;
	}

	public Date getCreatedat() {
		return _createdat;
	}
	public void setCreatedat(Date createdat) {
		this._createdat = createdat;
	}

	
	protected ICatManager getCatManager() {
		return _catManager;
	}
	public void setCatManager(ICatManager catManager) {
		this._catManager = catManager;
	}
	
	private int _strutsAction;
	private int _id;
	private String _name;
	private int _age;
	private BigDecimal _weight;
	private Date _createdat;
	
	private ICatManager _catManager;
	
}