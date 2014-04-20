/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat;

import java.util.Date;
import java.math.BigDecimal;

public class Cat {

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

	
	private int _id;
	private String _name;
	private int _age;
	private BigDecimal _weight;
	private Date _createdat;

}
