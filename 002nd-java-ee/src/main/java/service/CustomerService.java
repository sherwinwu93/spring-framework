package service;

import jdbc.MySqlUtil;
import po.Customer;

public class CustomerService {
	public void addCustomer(Customer customer) {
		String name = customer.getName();
		String username = customer.getUsername();
		MySqlUtil.update("insert into customer(name, username) values(?, ?)",
				name, username);
	}
}
