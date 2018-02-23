package h2webapp;


import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class CustomerDao {
 
  @Autowired NamedParameterJdbcTemplate jdbcTemplate;
 
    public NamedParameterJdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
  //setter for jdbcTemplate for testing with alternative db
public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	private static final String SQL_FIND_ALL= "SELECT * FROM customer";
    private static final String SQL_INSERT = "insert into customer (first_name, last_name, date_of_birth, username, password) values (:first_name, :last_name, :date_of_birth, :username, :password)";
	private static final String SQL_UPDATE = "update customer set first_name=:first_name, last_name=:last_name,date_of_birth=:date_of_birth,username=:username,password=:password where id=:id";
	private static final String SQL_FIND_ONE = "select * from customer where id = :id";
	private static final String SQL_DELETE_ONE = "delete from customer where id = :id";
  public List<Customer> getCustomers(){
    return jdbcTemplate.query(SQL_FIND_ALL, 
      (ResultSet rs, int rowNum) -> {
        Customer p = new Customer();
        p.setId(rs.getInt("id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setDateOfBirth(rs.getDate("date_of_birth"));
        p.setUsername(rs.getString("username"));
        p.setPassword(rs.getString("password"));
        return p;
    });
  }
  
  public int save(final Customer cust) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", cust.getFirstName());
        paramMap.put("last_name", cust.getLastName());
        paramMap.put("date_of_birth", cust.getDateOfBirth());
        paramMap.put("username", cust.getUsername());
        paramMap.put("password", cust.getPassword());
		return jdbcTemplate.update(SQL_INSERT,paramMap);
	}
  public int update(final Customer cust) {
	  Map<String, Object> paramMap = new HashMap<String, Object>();
      paramMap.put("first_name", cust.getFirstName());
      paramMap.put("last_name", cust.getLastName());
      paramMap.put("date_of_birth", cust.getDateOfBirth());
      paramMap.put("username", cust.getUsername());
      paramMap.put("password", cust.getPassword());
      paramMap.put("id", cust.getId());
		return jdbcTemplate.update(SQL_UPDATE,paramMap);
	  
  }
  public Customer findByCustomerId(int custId){
	  
	  
	  Map<String, Object> paramMap = new HashMap<String, Object>();
	  paramMap.put("id", custId);
	  List<Customer> custlist= jdbcTemplate.query(SQL_FIND_ONE, paramMap, 
		      (ResultSet rs, int rowNum) -> {
		        Customer p = new Customer();
		        p.setId(rs.getInt("id"));
		        p.setFirstName(rs.getString("first_name"));
		        p.setLastName(rs.getString("last_name"));
		        p.setDateOfBirth(rs.getDate("date_of_birth"));
		        p.setUsername(rs.getString("username"));
		        p.setPassword(rs.getString("password"));
		        return p;
		    });
	  if(custlist.size()!=0)
	  return custlist.get(0);
	  else
		  return null;
	}
  public int deleteCustomer(int custId) {
	  Map<String, Object> paramMap = new HashMap<String, Object>();
	  paramMap.put("id", custId);
	  return jdbcTemplate.update(SQL_DELETE_ONE, paramMap);
  }
	
}