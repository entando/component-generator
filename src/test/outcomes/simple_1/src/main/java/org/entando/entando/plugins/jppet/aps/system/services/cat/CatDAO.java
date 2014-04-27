/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.commons.lang.StringUtils;
import com.agiletec.aps.system.common.AbstractSearcherDAO;
import com.agiletec.aps.system.common.FieldSearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatDAO extends AbstractSearcherDAO implements ICatDAO {

	private static final Logger _logger =  LoggerFactory.getLogger(CatDAO.class);

	@Override
	protected String getTableFieldName(String metadataFieldKey) {
		return metadataFieldKey;
	}
	
	@Override
	protected String getMasterTableName() {
		return "jppet_cat";
	}
	
	@Override
	protected String getMasterTableIdFieldName() {
		return "id";
	}
	
	@Override
	protected boolean isForceCaseInsensitiveLikeSearch() {
		return true;
	}

	@Override
	public List<Integer> searchCats(FieldSearchFilter[] filters) {
		List catsId = null;
		try {
			catsId  = super.searchId(filters);
		} catch (Throwable t) {
			_logger.error("error in searchCats",  t);
			throw new RuntimeException("error in searchCats", t);
		}
		return catsId;
	}

	@Override
	public List<Integer> loadCats() {
		List<Integer> catsId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			stat = conn.prepareStatement(LOAD_CATS_ID);
			res = stat.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				catsId.add(id);
			}
		} catch (Throwable t) {
			_logger.error("Error loading Cat list",  t);
			throw new RuntimeException("Error loading Cat list", t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return catsId;
	}
	
	@Override
	public void insertCat(Cat cat) {
		PreparedStatement stat = null;
		Connection conn  = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.insertCat(cat, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error on insert cat",  t);
			throw new RuntimeException("Error on insert cat", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void insertCat(Cat cat, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(ADD_CAT);
			int index = 1;
			stat.setInt(index++, cat.getId());
 			stat.setString(index++, cat.getName());
			stat.setInt(index++, cat.getAge());
 			if(null != cat.getWeight()) {
				stat.setBigDecimal(index++, cat.getWeight());				
			} else {
				stat.setNull(index++, Types.DECIMAL);
			}
			if(null != cat.getCreatedat()) {
				Timestamp createdatTimestamp = new Timestamp(cat.getCreatedat().getTime());
				stat.setTimestamp(index++, createdatTimestamp);	
			} else {
				stat.setNull(index++, Types.DATE);
			}
 			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error on insert cat",  t);
			throw new RuntimeException("Error on insert cat", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void updateCat(Cat cat) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.updateCat(cat, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error updating cat {}", cat.getId(),  t);
			throw new RuntimeException("Error updating cat", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void updateCat(Cat cat, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE_CAT);
			int index = 1;

 			stat.setString(index++, cat.getName());
			stat.setInt(index++, cat.getAge());
 			if(null != cat.getWeight()) {
				stat.setBigDecimal(index++, cat.getWeight());				
			} else {
				stat.setNull(index++, Types.DECIMAL);
			}
			if(null != cat.getCreatedat()) {
				Timestamp createdatTimestamp = new Timestamp(cat.getCreatedat().getTime());
				stat.setTimestamp(index++, createdatTimestamp);	
			} else {
				stat.setNull(index++, Types.DATE);
			}
 			stat.setInt(index++, cat.getId());
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error updating cat {}", cat.getId(),  t);
			throw new RuntimeException("Error updating cat", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void removeCat(int id) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.removeCat(id, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error deleting cat {}", id, t);
			throw new RuntimeException("Error deleting cat", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}
	
	public void removeCat(int id, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE_CAT);
			int index = 1;
			stat.setInt(index++, id);
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error deleting cat {}", id, t);
			throw new RuntimeException("Error deleting cat", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	public Cat loadCat(int id) {
		Cat cat = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			cat = this.loadCat(id, conn);
		} catch (Throwable t) {
			_logger.error("Error loading cat with id {}", id, t);
			throw new RuntimeException("Error loading cat with id " + id, t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return cat;
	}

	public Cat loadCat(int id, Connection conn) {
		Cat cat = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			stat = conn.prepareStatement(LOAD_CAT);
			int index = 1;
			stat.setInt(index++, id);
			res = stat.executeQuery();
			if (res.next()) {
				cat = this.buildCatFromRes(res);
			}
		} catch (Throwable t) {
			_logger.error("Error loading cat with id {}", id, t);
			throw new RuntimeException("Error loading cat with id " + id, t);
		} finally {
			closeDaoResources(res, stat, null);
		}
		return cat;
	}

	protected Cat buildCatFromRes(ResultSet res) {
		Cat cat = null;
		try {
			cat = new Cat();				
			cat.setId(res.getInt("id"));
			cat.setName(res.getString("name"));
			cat.setAge(res.getInt("age"));
			cat.setWeight(res.getBigDecimal("weight"));
			Timestamp createdatValue = res.getTimestamp("createdat");
			if (null != createdatValue) {
				cat.setCreatedat(new Date(createdatValue.getTime()));
			}
		} catch (Throwable t) {
			_logger.error("Error in buildCatFromRes", t);
		}
		return cat;
	}

	private static final String ADD_CAT = "INSERT INTO jppet_cat (id, name, age, weight, createdat ) VALUES (?, ?, ?, ?, ? )";

	private static final String UPDATE_CAT = "UPDATE jppet_cat SET  name=?,  age=?,  weight=?, createdat=? WHERE id = ?";

	private static final String DELETE_CAT = "DELETE FROM jppet_cat WHERE id = ?";
	
	private static final String LOAD_CAT = "SELECT id, name, age, weight, createdat  FROM jppet_cat WHERE id = ?";
	
	private static final String LOAD_CATS_ID  = "SELECT id FROM jppet_cat";
	
}