package info._7chapters.hr.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;


public class StringTrimTypeHandler implements TypeHandler<String> {

	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		if (parameter != null) {
			ps.setString(i, parameter.trim());
		}
	}
	
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		return (rs.getString(columnName) != null) ? rs.getString(columnName).trim() : null;
	}
	  
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		return (rs.getString(columnIndex) != null) ? rs.getString(columnIndex).trim() : null;
	}
	  
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return (cs.getString(columnIndex) != null) ? cs.getString(columnIndex).trim() : null;
	}	
}
