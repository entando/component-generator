/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import com.agiletec.aps.system.common.FieldSearchFilter;

public interface ICatDAO {

	public List<Integer> searchCats(FieldSearchFilter[] filters);
	
	public Cat loadCat(int id);

	public List<Integer> loadCats();

	public void removeCat(int id);
	
	public void updateCat(Cat cat);

	public void insertCat(Cat cat);
	

}