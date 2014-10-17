package com.javabros;

import java.util.List;

import com.javabros.model.Customer;
import com.javabros.util.DBUtil;

public class Main {
	public static void main(String[] args) {
		DBUtil util=new DBUtil();
		System.out.println("-------List of Customers------------");
		List<Customer> c=util.getCustomers();
		for(Customer cust:c){
			System.out.println(cust);
		}
		
		util.updateCity(2, "Kandukur");
		c=util.getCustomers();
		System.out.println("-------After Update----------------");
		for(Customer cust:c){
			System.out.println(cust);
		}
		
		util.deleteCustomer(2);
		System.out.println("-------After Delete----------------");
		c=util.getCustomers();
		for(Customer cust:c){
			System.out.println(cust);
		}
		
		
		util.destroy();
	}
}
