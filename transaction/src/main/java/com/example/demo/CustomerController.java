package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService cs;

	@Autowired
	Transaction transfer;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView menu(ModelAndView mandv) {
		mandv.setViewName("menu");

		return mandv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "create")
	public ModelAndView createCustomer(ModelAndView mandv) {

		Customer dto = new Customer();
		mandv.addObject("customer", dto);
		mandv.setViewName("createCustomerForm");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "create")
	public ModelAndView createCustomer(Customer customer, ModelAndView mandv) {
		mandv.setViewName("createdone");
		// TODO Auto-generated method stub
		cs.createCustomer(customer);
		return mandv;
	}

	@RequestMapping(method = RequestMethod.GET, value="/findbyid")
	public ModelAndView getId(ModelAndView mandv) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		mandv.addObject("bank", customer);
		mandv.setViewName("checkbalance");
		 return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/findbyid")
	public ModelAndView getId(Customer customer, ModelAndView mandv) {
		// TODO Auto-generated method stub
		Customer dto=cs.findById(customer.getUid());
		mandv.addObject("bank", dto);
		mandv.setViewName("balance");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/moneytransfer")
	public ModelAndView moneyTransfer(ModelAndView mandv) {
		Transfer transfer = new Transfer();
		mandv.addObject("trans", transfer);
		mandv.setViewName("transfer");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/moneytransfer")
	public ModelAndView moneyTransfer(ModelAndView mandv,int crid,int deid,int amt) throws Insufficient {
		transfer.moneyTransfer(crid, deid, amt);
		mandv.setViewName("transferdone");
		return mandv;
	}

}
class Transfer{
	private int crid;
	private int deid;
	private int amt;
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
		this.crid = crid;
	}
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	
}