/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services.cat.api;

import java.util.Date;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.myportal.aps.system.services.cat.Cat;

@XmlRootElement(name = "cat")
@XmlType(propOrder = {"id", "name", "age", "weight", "createdat"})
public class JAXBCat {

    public JAXBCat() {
        super();
    }

    public JAXBCat(Cat cat) {
		this.setId(cat.getId());
		this.setName(cat.getName());
		this.setAge(cat.getAge());
		this.setWeight(cat.getWeight());
		this.setCreatedat(cat.getCreatedat());
    }
    
    public Cat getCat() {
    	Cat cat = new Cat();
		cat.setId(this.getId());
		cat.setName(this.getName());
		cat.setAge(this.getAge());
		cat.setWeight(this.getWeight());
		cat.setCreatedat(this.getCreatedat());
    	return cat;
    }

	@XmlElement(name = "id", required = true)
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	@XmlElement(name = "name", required = true)
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}

	@XmlElement(name = "age", required = true)
	public int getAge() {
		return _age;
	}
	public void setAge(int age) {
		this._age = age;
	}

	@XmlElement(name = "weight", required = true)
	public BigDecimal getWeight() {
		return _weight;
	}
	public void setWeight(BigDecimal weight) {
		this._weight = weight;
	}

	@XmlElement(name = "createdat", required = true)
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
