package h2webapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.text.ParseException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class CustomerDaoTest {

	  public DataSource TestdataSource() {
		    return new EmbeddedDatabaseBuilder()
		      .generateUniqueName(false)
		      .setName("testdbtest")
		      .setType(EmbeddedDatabaseType.H2)
		      .addScripts("schema.sql","testdata.sql")
		      .setScriptEncoding("UTF-8")
		      .ignoreFailedDrops(true)
		      .build();
		  }
	 
	 public NamedParameterJdbcTemplate namedParamJdbcTemplateTest() {
		    NamedParameterJdbcTemplate namedParamJdbcTemplate = 
		      new NamedParameterJdbcTemplate(TestdataSource());
		    return namedParamJdbcTemplate;
		  }
	 
	@Test
	public void findByCustomerIdTest()
	{
		CustomerDao customerDao= new CustomerDao();
		customerDao.setJdbcTemplate(namedParamJdbcTemplateTest());
		
		assertEquals( "First",customerDao.findByCustomerId(1).getFirstName());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getCustomersTest()
	{
		CustomerDao customerDao= new CustomerDao();
		customerDao.setJdbcTemplate(namedParamJdbcTemplateTest());
		
		String[] result_names= {customerDao.getCustomers().get(0).getFirstName(),
		                       customerDao.getCustomers().get(1).getFirstName(),
		                       customerDao.getCustomers().get(2).getFirstName(),
		                       customerDao.getCustomers().get(3).getFirstName()};
		String[] true_names= {"First","First2","First3","First4"};
		assertEquals(true_names, result_names);
	}
	@Test
	public void saveTest() throws ParseException {
		CustomerDao customerDao= new CustomerDao();
		customerDao.setJdbcTemplate(namedParamJdbcTemplateTest());
		
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		Customer testcustomer= new Customer(5,"eesnimi","perenimi",date,"kasutajanimi","parool");
		customerDao.save(testcustomer);
		
		assertEquals(date, customerDao.findByCustomerId(5).getDateOfBirth());
		
	}
	@Test
	public void updateTest() {
		CustomerDao customerDao= new CustomerDao();
		customerDao.setJdbcTemplate(namedParamJdbcTemplateTest());
		
		Customer cust=customerDao.findByCustomerId(3);
		cust.setFirstName("Updatetest");
		customerDao.update(cust);
		assertEquals("Updatetest", customerDao.findByCustomerId(3).getFirstName());
	}
	@Test
	public void deleteCustomerTest() {
		CustomerDao customerDao= new CustomerDao();
		customerDao.setJdbcTemplate(namedParamJdbcTemplateTest());
		
		Customer cust=customerDao.findByCustomerId(1);
		customerDao.deleteCustomer(1);
		String resultname="";
		if(customerDao.findByCustomerId(1) != null) {
			resultname+=customerDao.findByCustomerId(1).getFirstName();
		}
		
		assertNotEquals(cust.getFirstName(), resultname);
	}
}
