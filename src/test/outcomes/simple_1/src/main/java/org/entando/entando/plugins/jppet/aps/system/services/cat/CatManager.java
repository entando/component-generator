/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat;

import org.entando.entando.plugins.jppet.aps.system.services.cat.event.CatChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Response;
import org.entando.entando.plugins.jppet.aps.system.services.cat.api.JAXBCat;
import org.entando.entando.aps.system.services.api.IApiErrorCodes;
import org.entando.entando.aps.system.services.api.model.ApiException;
import java.util.Date;
import java.math.BigDecimal;
import com.agiletec.aps.system.common.FieldSearchFilter;
import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.keygenerator.IKeyGeneratorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatManager extends AbstractService implements ICatManager {

	private static final Logger _logger =  LoggerFactory.getLogger(CatManager.class);

	@Override
	public void init() throws Exception {
		_logger.debug("{} ready.", this.getClass().getName());
	}
 
	@Override
	public Cat getCat(int id) throws ApsSystemException {
		Cat cat = null;
		try {
			cat = this.getCatDAO().loadCat(id);
		} catch (Throwable t) {
			_logger.error("Error loading cat with id '{}'", id,  t);
			throw new ApsSystemException("Error loading cat with id: " + id, t);
		}
		return cat;
	}

	@Override
	public List<Integer> getCats() throws ApsSystemException {
		List<Integer> cats = new ArrayList<Integer>();
		try {
			cats = this.getCatDAO().loadCats();
		} catch (Throwable t) {
			_logger.error("Error loading Cat list",  t);
			throw new ApsSystemException("Error loading Cat ", t);
		}
		return cats;
	}

	@Override
	public List<Integer> searchCats(FieldSearchFilter filters[]) throws ApsSystemException {
		List<Integer> cats = new ArrayList<Integer>();
		try {
			cats = this.getCatDAO().searchCats(filters);
		} catch (Throwable t) {
			_logger.error("Error searching Cats", t);
			throw new ApsSystemException("Error searching Cats", t);
		}
		return cats;
	}

	@Override
	public void addCat(Cat cat) throws ApsSystemException {
		try {
			int key = this.getKeyGeneratorManager().getUniqueKeyCurrentValue();
			cat.setId(key);
			this.getCatDAO().insertCat(cat);
			this.notifyCatChangedEvent(cat, CatChangedEvent.INSERT_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error adding Cat", t);
			throw new ApsSystemException("Error adding Cat", t);
		}
	}
 
	@Override
	public void updateCat(Cat cat) throws ApsSystemException {
		try {
			this.getCatDAO().updateCat(cat);
			this.notifyCatChangedEvent(cat, CatChangedEvent.UPDATE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error updating Cat", t);
			throw new ApsSystemException("Error updating Cat " + cat, t);
		}
	}

	@Override
	public void deleteCat(int id) throws ApsSystemException {
		try {
			Cat cat = this.getCat(id);
			this.getCatDAO().removeCat(id);
			this.notifyCatChangedEvent(cat, CatChangedEvent.REMOVE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error deleting Cat with id {}", id, t);
			throw new ApsSystemException("Error deleting Cat with id:" + id, t);
		}
	}


	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/cats?
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
	public List<JAXBCat> getCatsForApi(Properties properties) throws Throwable {
		List<JAXBCat> list = new ArrayList<JAXBCat>();
		List<Integer> idList = this.getCats();
		if (null != idList && !idList.isEmpty()) {
			Iterator<Integer> catIterator = idList.iterator();
			while (catIterator.hasNext()) {
				int currentid = catIterator.next();
				Cat cat = this.getCat(currentid);
				if (null != cat) {
					list.add(new JAXBCat(cat));
				}
			}
		}
		return list;
	}

	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/cat?id=1
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
    public JAXBCat getCatForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
		JAXBCat jaxbCat = null;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        Cat cat = this.getCat(id);
        if (null == cat) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Cat with id '" + idString + "' does not exist", Response.Status.CONFLICT);
        }
        jaxbCat = new JAXBCat(cat);
        return jaxbCat;
    }

    /**
     * POST Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/cat 
     * @param jaxbCat
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void addCatForApi(JAXBCat jaxbCat) throws ApiException, ApsSystemException {
        if (null != this.getCat(jaxbCat.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Cat with id " + jaxbCat.getId() + " already exists", Response.Status.CONFLICT);
        }
        Cat cat = jaxbCat.getCat();
        this.addCat(cat);
    }

    /**
     * PUT Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/cat 
     * @param jaxbCat
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void updateCatForApi(JAXBCat jaxbCat) throws ApiException, ApsSystemException {
        if (null == this.getCat(jaxbCat.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Cat with id " + jaxbCat.getId() + " does not exist", Response.Status.CONFLICT);
        }
        Cat cat = jaxbCat.getCat();
        this.updateCat(cat);
    }

    /**
     * DELETE http://localhost:8080/<portal>/api/rs/en/cat?id=1
	 * @param properties
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void deleteCatForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        this.deleteCat(id);
    }

	private void notifyCatChangedEvent(Cat cat, int operationCode) {
		CatChangedEvent event = new CatChangedEvent();
		event.setCat(cat);
		event.setOperationCode(operationCode);
		this.notifyEvent(event);
	}


	protected IKeyGeneratorManager getKeyGeneratorManager() {
		return _keyGeneratorManager;
	}
	public void setKeyGeneratorManager(IKeyGeneratorManager keyGeneratorManager) {
		this._keyGeneratorManager = keyGeneratorManager;
	}

	public void setCatDAO(ICatDAO catDAO) {
		 this._catDAO = catDAO;
	}
	protected ICatDAO getCatDAO() {
		return _catDAO;
	}

	private IKeyGeneratorManager _keyGeneratorManager;
	private ICatDAO _catDAO;
}
