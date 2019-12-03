package com.slk.dao;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.bean.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer,HttpServletRequest request) throws SQLException;
	void UpdateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	List<Customer> getAllCustomer()  throws SQLException ;
	List<Customer> getAllTransaction()  throws SQLException ;
	Customer getCustomerById(int id);
	

}
