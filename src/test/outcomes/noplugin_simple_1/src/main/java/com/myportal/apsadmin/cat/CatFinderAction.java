/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.apsadmin.cat;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import java.util.Date;
import java.math.BigDecimal;
import com.agiletec.aps.system.common.FieldSearchFilter;
import com.myportal.aps.system.services.cat.Cat;
import com.myportal.aps.system.services.cat.ICatManager;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatFinderAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(CatFinderAction.class);

	public List<Integer> getCatsId() {
		try {
			FieldSearchFilter[] filters = new FieldSearchFilter[0];
			if (null != this.getId()) {
				//TODO add a constant into your ICatManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("id"), this.getId(), false);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getName())) {
				//TODO add a constant into your ICatManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("name"), this.getName(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (null != this.getAge()) {
				//TODO add a constant into your ICatManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("age"), this.getAge(), false);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (null != this.getWeight()) {
				//TODO add a constant into your ICatManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("weight"), this.getWeight(), false);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (null != this.getCreatedatStart() || null != this.getCreatedatEnd()) {
				Date startDate = this.getCreatedatStart();
				Date endDate = this.getCreatedatEnd();
				//TODO add a constant into your ICatManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("createdat"), startDate, endDate);
				filters = this.addFilter(filters, filterToAdd);
			}

			List<Integer> cats = this.getCatManager().searchCats(filters);
			return cats;
		} catch (Throwable t) {
			_logger.error("Error getting cats list", t);
			throw new RuntimeException("Error getting cats list", t);
		}
	}

	protected FieldSearchFilter[] addFilter(FieldSearchFilter[] filters, FieldSearchFilter filterToAdd) {
		int len = filters.length;
		FieldSearchFilter[] newFilters = new FieldSearchFilter[len + 1];
		for(int i=0; i < len; i++){
			newFilters[i] = filters[i];
		}
		newFilters[len] = filterToAdd;
		return newFilters;
	}

	public Cat getCat(int id) {
		Cat cat = null;
		try {
			cat = this.getCatManager().getCat(id);
		} catch (Throwable t) {
			_logger.error("Error getting cat with id {}", id, t);
			throw new RuntimeException("Error getting cat with id " + id, t);
		}
		return cat;
	}


	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
		this._id = id;
	}


	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}


	public Integer getAge() {
		return _age;
	}
	public void setAge(Integer age) {
		this._age = age;
	}


	public BigDecimal getWeight() {
		return _weight;
	}
	public void setWeight(BigDecimal weight) {
		this._weight = weight;
	}


	public Date getCreatedatStart() {
		return _createdatStart;
	}
	public void setCreatedatStart(Date createdatStart) {
		this._createdatStart = createdatStart;
	}


	public Date getCreatedatEnd() {
		return _createdatEnd;
	}
	public void setCreatedatEnd(Date createdatEnd) {
		this._createdatEnd = createdatEnd;
	}


	protected ICatManager getCatManager() {
		return _catManager;
	}
	public void setCatManager(ICatManager catManager) {
		this._catManager = catManager;
	}
	
	private Integer _id;
	private String _name;
	private Integer _age;
	private BigDecimal _weight;
	private Date _createdatStart;
	private Date _createdatEnd;
	private ICatManager _catManager;
}