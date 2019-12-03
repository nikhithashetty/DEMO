package com.slk.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.bean.Customer;
import com.slk.util.DBUtil;

public class CustomerDAOimpl implements CustomerDAO{
	Connection con=null;
	public CustomerDAOimpl()
	{
		con=DBUtil.getConnection();
	}


	public void addCustomer(Customer customer,HttpServletRequest request) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement pt=con.prepareStatement("insert into customer values(?,?,?)");
		 String id=request.getParameter("id");
		 String name=request.getParameter("name");
		 String address=request.getParameter("address");
		 pt.setInt(1, Integer.parseInt(id));
		 pt.setString(2, name);
		 pt.setString(3, address);
		 pt.executeUpdate();
		 //set browser content type which is in  html
		   
	}

	@Override
	public void UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
		String sql="UPDATE customer set id=?,name=?,address=? WHERE id= ?";
		
			PreparedStatement pt=con.prepareStatement(sql);
			
			pt.setInt(1,customer.getCust_id());
			pt.setString(2,customer.getName());
			pt.setString(3,customer.getAddress());
			pt.setInt(4,customer.getCust_id());
			int res=pt.executeUpdate();
			if(res > 0){
				System.out.println("Customer Updated");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
	try{
			
			String sql="DELETE FROM customer WHERE id = ? ";			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, customer.getCust_id());
			
			int res  = pst.executeUpdate();
			
			if(res > 0){
				System.out.println("Employee Deleted");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	

	@Override
	public List<Customer> getAllCustomer() throws SQLException {
		// TODO Auto-generated method stub

		 String query1="select * from Customer";
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery(query1);
			List<Customer> l=new ArrayList<Customer>();
			while(rs.next())
			{
				Customer c=new Customer();
		         c.setCust_id(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				l.add(c);
				
				
			}
		
	
	
	
		return l;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		 String query1="select * from Customer where id="+id;
			Statement st1;
			try {
				st1 = con.createStatement();
				ResultSet rs=st1.executeQuery(query1);
				rs.next();
			  c.setCust_id(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return c;
	}


	@Override
	public List<Customer> getAllTransaction() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	

}
