package com.customermanagment.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customermanagment.dao.AdminDAO;
import com.customermanagment.dao.CustomerDAO;
import com.customermanagment.exception.CustomerException;
import com.customermanagment.model.Admin;
import com.customermanagment.model.CustomerInfo;
import com.customermanagment.request.CustomerRequest;

@WebServlet("/")
public class CustomerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/page":

			getPage(request, response);
			break;

		case "/adminlogin":
			getAdminLogin(request, response);
			break;

		case "/deleteform":

			deleteCustomer(request, response);
			break;

		case "/edit":
			updateCustomer(request, response);

			break;
		case "/editform":
			getEditForm(request, response);
			break;

		case "/addcustomer":
			registrationForm(request, response);
			break;

		case "/signup":
			saveCustomer(request, response);
			break;

		case "/table":
			getCustomerListPage(request, response);
			break;
		default:
			getStartUpPage(request, response);
			break;

		}
	}

	private void getPage(HttpServletRequest request, HttpServletResponse response) {

	}

	private void getCustomerListPage(HttpServletRequest request, HttpServletResponse response) {
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		int limit=1;

		List<CustomerInfo> listOfCustomer = CustomerDAO.getAllCustomers(limit,pageNo);

		RequestDispatcher rd = request.getRequestDispatcher("customer_list.jsp");

		try {
			
			request.setAttribute("PageNo", pageNo);
			
			request.setAttribute("CustomerDetails", listOfCustomer);
			
			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

	private void getAdminLogin(HttpServletRequest request, HttpServletResponse response) {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		boolean b = AdminDAO.getAdminLogin(userName, password);

		if (b == true) {
			getCustomerListPage(request, response);
		} else {
			throw new CustomerException(400, "Email && password does't match");
		}

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {

		int sNo = Integer.parseInt(request.getParameter("sno"));

		try {
			CustomerDAO.deleteCustomer(sNo);

			getCustomerListPage(request, response);

			RequestDispatcher rd = request.getRequestDispatcher("customer_list.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			e.getLocalizedMessage();
		}

	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {

		int sNo = Integer.parseInt(request.getParameter("sno"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String sex = request.getParameter("gender");
		Date dob = Date.valueOf(request.getParameter("DOB"));
		String permanentAddress = request.getParameter("permanentAddress");
		String residenceAddress = request.getParameter("residenceAddress");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		int areaCode = Integer.parseInt(request.getParameter("areaCode"));
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");

		CustomerInfo cI = new CustomerInfo(sNo, firstName, lastName, sex, dob, permanentAddress, residenceAddress,
				state, city, zipCode, areaCode, mobileNo, email);

		try {
			CustomerDAO.updateCustomer(cI);

			getCustomerListPage(request, response);

			RequestDispatcher rd = request.getRequestDispatcher("customer_list.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	private void getEditForm(HttpServletRequest request, HttpServletResponse response) {

		int sNo = Integer.parseInt(request.getParameter("sno"));

		CustomerInfo c = CustomerDAO.editCustomer(sNo);

		try {

			RequestDispatcher rd = request.getRequestDispatcher("addcustomer_form.jsp");

			request.setAttribute("customer", c);

			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void registrationForm(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("addcustomer_form.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String sex = request.getParameter("gender");
		Date dob = Date.valueOf(request.getParameter("DOB"));
		String permanentAddress = request.getParameter("permanentAddress");
		String residenceAddress = request.getParameter("residenceAddress");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		int areaCode = Integer.parseInt(request.getParameter("areaCode"));
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");

		CustomerRequest cr = new CustomerRequest(firstName, lastName, sex, dob, permanentAddress, residenceAddress,
				state, city, zipCode, areaCode, mobileNo, email);

		CustomerDAO.saveCustomerInfo(cr);

		getCustomerListPage(request, response);

		RequestDispatcher rd = request.getRequestDispatcher("customer_list.jsp");

		try {
			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("admin_login.jsp");

		try {

			rd.forward(request, response);

		} catch (ServletException | IOException e) {
			throw new CustomerException(400, e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
