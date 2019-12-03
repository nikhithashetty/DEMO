package com.slk.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher ;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.slk.bean.Customer;
import com.slk.dao.CustomerDAO;
import com.slk.dao.CustomerDAOimpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//create instance of bean class
	private static String LIST_CUSTOMER="/listCust.jsp";
	private static String INSERT_OR_EDIT="/Edit.jsp";
	String forward;
	CustomerDAO customerdao;
	Customer c=new Customer();
	public String url;
	public String pass;
	public String uname;
	public Connection con;
	CustomerDAOimpl cc=new CustomerDAOimpl();
	
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
        customerdao=new CustomerDAOimpl();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/* response.setContentType("text/html");//set browser content type which is in  html
		   
		 PrintWriter out=response.getWriter();
		 c.setCust_id(101);
		 c.setName("Nikhitha");
		 c.setAddress("Mangalore");
		 out.println("ID of customer:"+c.getCust_id());
		 out.println("<br>");
		 out.println("Name of customer:"+c.getName());
		 out.println("<br>");
		 out.println("Address of customer:"+c.getAddress());*/
		String action=request.getParameter("action");
		if(action.equals("listCust"))
		{
			forward=LIST_CUSTOMER;
			try {
				List<Customer> ll=cc.getAllCustomer();
				request.setAttribute("Customer",ll);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else if(action.equals("delete"))
		{
			forward=INSERT_OR_EDIT;
			String id=request.getParameter("id");
			c.setCust_id(Integer.parseInt(id));
			cc.deleteCustomer(c);
		}
		else if(action.equals("edit"))
		{

			forward=INSERT_OR_EDIT;
			String id=request.getParameter("id");
			Customer c=cc.getCustomerById(Integer.parseInt(id));
			request.setAttribute("customers", c);
			
			
		}
	RequestDispatcher view =request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		if(btn.equals("Edit"))
		{

		String id=request.getParameter("id1");
		 String name=request.getParameter("name1");
		 String address=request.getParameter("address1");
		
	
		 c.setCust_id(Integer.parseInt(id));
		 c.setName(name);
		 c.setAddress(address);
		cc.UpdateCustomer(c);
		}
		
		 if(btn.equals("submit"))
		{

       System.out.println("Inside submit");
			try {
				cc.addCustomer(c, request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
	
	
	
		
		 
	}	 
	
}
}


