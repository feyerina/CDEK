package testtask.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import testtask.model.Element;

@Repository
public class ElementDaoImpl implements ElementDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	public List<Element> listAllElements() {
		String sql = "SELECT id, name FROM elements";
		
		List<Element> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ElementMapper());
		
		return list;
	}
	

	 private SqlParameterSource getSqlParameterByModel(Element element){
	  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	  if(element != null){
	   parameterSource.addValue("id", element.getId());
	   parameterSource.addValue("name", element.getName());
	  }
	  return parameterSource;
	 }
	 
	 private static final class ElementMapper implements RowMapper<Element>{

	  public Element mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Element element = new Element();
	   element.setId(rs.getInt("id"));
	   element.setName(rs.getString("name"));
	   
	   return element;
	  }
	  
	 }

	public void addElement(Element element) {
		String sql = "INSERT INTO elements(name) VALUES(:name)";
				  
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(element));
		
	}
	
	public void updateElement(Element element) {
	    String sql = "UPDATE elements SET name = :name WHERE id = :id";
		  
	    namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(element));
    }
	
	public Element findElementById(int id) {
		  String sql = "SELECT * FROM elements WHERE id = :id";
		  
		  return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Element(id)), new ElementMapper());
		 }

}
