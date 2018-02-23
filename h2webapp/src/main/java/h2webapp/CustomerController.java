package h2webapp;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired CustomerDao customerDao;
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	@RequestMapping("new")
	public ModelAndView add(@RequestParam String firstname, 
							@RequestParam String lastname, 
							@RequestParam Date dateofbirth, 
							@RequestParam String username, 
							@RequestParam String password)
	{
		
		
		Customer newcust= new Customer(firstname,lastname, dateofbirth, username, password);
		
		int customerok=customerDao.save(newcust);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("customers/customer.jsp");
		List<Customer> customers= customerDao.getCustomers();
		mv.addObject("customers", customers);
		return mv;
	}
	 

	  @RequestMapping("customers")
	  public ModelAndView test(){
		  ModelAndView mv= new ModelAndView();
		  mv.setViewName("customers/customer.jsp");
		  
		  List<Customer> customers= customerDao.getCustomers();
		  for(Customer customer  :customers) 
		  {
			  System.out.println(customer.getFirstName());
		  }
		  mv.addObject("customers", customers);
		  return mv;
	  }
	  @RequestMapping("customers/{id}")
	  public ModelAndView CustUpdateView(@PathVariable int id){
		  Customer cust= customerDao.findByCustomerId(id);
		  ModelAndView mv= new ModelAndView();
		  mv.clear();
		  mv.setViewName("update.jsp");
		  mv.addObject("customer",cust);
		  return mv;
		  
	  }
	  @RequestMapping("customers/update")
	  public ModelAndView Update(@RequestParam int id, 
			  					@RequestParam String firstname,
			  					@RequestParam String lastname,
			  					@RequestParam Date dateofbirth,
			  					@RequestParam String username,
			  					@RequestParam String password) {
		  ModelAndView mv=new ModelAndView();
		  Customer cust=new Customer(id,firstname,lastname,dateofbirth,username,password);
		  int success= customerDao.update(cust);
		  List<Customer> customers= customerDao.getCustomers();
		  mv.clear();
		  mv.setViewName("customer.jsp");
		  mv.addObject("customers",customers);
		  return mv;
		  
	  }
	  @RequestMapping("customers/delete")
	  public ModelAndView deleteCustomer(@RequestParam int id) 
	  {
		  ModelAndView mv= new ModelAndView();
		  int deleteconfirmed=customerDao.deleteCustomer(id);
		  List<Customer> customers= customerDao.getCustomers();
		  mv.setViewName("customer.jsp");
		  mv.addObject("customers",customers);
		  if(deleteconfirmed==1) {
			  return mv;
		  }
		  else {
			  mv.addObject("msg","Could not delete customer");
			  return mv;
		  }
		  
	  }

}