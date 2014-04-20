/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.init.servdb;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.math.BigDecimal;
import java.util.Date;

@DatabaseTable(tableName = Cat.TABLE_NAME)
public class Cat {
	
	public Cat() {}
	
	@DatabaseField(columnName = "id", 
		dataType = DataType.INTEGER, 
		 canBeNull=false, id = true)
	private int _id;
	
	@DatabaseField(columnName = "name", 
		dataType = DataType.STRING, 
		width=8,  canBeNull=false)
	private String _name;
	
	@DatabaseField(columnName = "age", 
		dataType = DataType.INTEGER, 
		 canBeNull= true)
	private int _age;
	
	@DatabaseField(columnName = "weight", 
			dataType = DataType.BIG_DECIMAL_NUMERIC,
		 canBeNull= true)
	private BigDecimal _weight;
	
	@DatabaseField(columnName = "createdat", 
			dataType = DataType.DATE,
		 canBeNull= true)
	private Date _createdat;
	

public static final String TABLE_NAME = "jppet_cat";
}
