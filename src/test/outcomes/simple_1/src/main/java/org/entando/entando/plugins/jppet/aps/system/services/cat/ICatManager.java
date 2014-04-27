/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat;

import java.util.List;
import com.agiletec.aps.system.exception.ApsSystemException;
import java.util.Date;
import java.math.BigDecimal;
import com.agiletec.aps.system.common.FieldSearchFilter;

public interface ICatManager {

	public Cat getCat(int id) throws ApsSystemException;

	public List<Integer> getCats() throws ApsSystemException;

	public List<Integer> searchCats(FieldSearchFilter filters[]) throws ApsSystemException;

	public void addCat(Cat cat) throws ApsSystemException;

	public void updateCat(Cat cat) throws ApsSystemException;

	public void deleteCat(int id) throws ApsSystemException;

}