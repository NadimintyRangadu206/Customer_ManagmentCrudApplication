package com.customermanagment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.customermanagment.exception.CustomerException;
import com.customermanagment.model.CustomerInfo;
import com.customermanagment.request.CustomerRequest;

public class CustomerDAO {

	private static final String dburl = "jdbc:mysql://localhost:3306/Customer_Managment";
	private static final String dbUserName = "root";
	private static final String dbPassword = "1234";

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static final String customerListQuery = "select * from CustomerInfo;";

	private static final String custSaveQuery = "insert into customerInfo"
			+ "(FirstName,LastName,Sex,DOB,PermanentAddress,ResidenceAddress,\r\n"
			+ "State,City,ZipCode,AreaCode,MobileNo,Email) " + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String CustomerEditQuery = "select * from CustomerInfo where SNo=?";

	private static final String updateCustomerQuery = "update customerInfo set" + " FirstName=?,LastName=?,Sex=?,DOB=?,"
			+ "PermanentAddress=?,ResidenceAddress=?,State=?,City=?,"
			+ "ZipCode=?,AreaCode=?,MobileNo=?,Email=? where SNo=?";

	private static final String deleteCustomerQuery = "delete  from customerInfo where SNo=?";

	public static Connection getDbConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUserName, dbPassword);

		} catch (ClassNotFoundException | SQLException e) {
			throw new CustomerException(400, e.getMessage());
		}

		return conn;
	}

	public static void deleteCustomer(int sNo) {

		conn = getDbConnection();

		try {
			ps = conn.prepareStatement(deleteCustomerQuery);

			ps.setInt(1, sNo);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
		}
	}

	public static void updateCustomer(CustomerInfo c) {

		conn = getDbConnection();

		try {
			ps = conn.prepareStatement(updateCustomerQuery);

			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getSex());
			ps.setDate(4, c.getDOB());
			ps.setString(5, c.getPermanentAddress());
			ps.setString(6, c.getResidenceAddress());
			ps.setString(7, c.getState());
			ps.setString(8, c.getCity());
			ps.setInt(9, c.getZipCode());
			ps.setInt(10, c.getAreaCode());
			ps.setString(11, c.getMobileNo());
			ps.setString(12, c.getEmail());
			ps.setInt(13, c.getsNo());

			ps.executeUpdate();

		} catch (Exception e) {
			e.getLocalizedMessage();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
		}
	}

	public static CustomerInfo editCustomer(int sNo) {

		CustomerInfo customer = null;
		conn = getDbConnection();

		try {
			ps = conn.prepareStatement(CustomerEditQuery);

			ps.setInt(1, sNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				int sN = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String sex = rs.getString(4);
				Date dob = rs.getDate(5);
				String permanentAddress = rs.getString(6);
				String residenceAddress = rs.getString(7);
				String state = rs.getString(8);
				String city = rs.getString(9);
				int zipCode = rs.getInt(10);
				int areaCode = rs.getInt(11);
				String mobileNo = rs.getString(12);
				String email = rs.getString(13);

				customer = new CustomerInfo(sN, firstName, lastName, sex, dob, permanentAddress, residenceAddress,
						state, city, zipCode, areaCode, mobileNo, email);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
		}
		return customer;

	}

	public static void saveCustomerInfo(CustomerRequest request) {

		conn = getDbConnection();

		try {

			ps = conn.prepareStatement(custSaveQuery);

			ps.setString(1, request.getFirstName());
			ps.setString(2, request.getLastName());
			ps.setString(3, request.getSex());
			ps.setDate(4, request.getDOB());
			ps.setString(5, request.getPermanentAddress());
			ps.setString(6, request.getResidenceAddress());
			ps.setString(7, request.getState());
			ps.setString(8, request.getCity());
			ps.setInt(9, request.getZipCode());
			ps.setInt(10, request.getAreaCode());
			ps.setString(11, request.getMobileNo());
			ps.setString(12, request.getEmail());

			ps.executeUpdate();

		} catch (Exception e) {
			e.getLocalizedMessage();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
		}
	}

	public static List<CustomerInfo> getAllCustomers(int limit,int pageNo) {

		conn = getDbConnection();

		List<CustomerInfo> listOfCustomers = new ArrayList<CustomerInfo>();
		try {
			ps = conn.prepareStatement(customerListQuery+"limit" +" "+limit +" "+"offset"+" "+pageNo);

			rs = ps.executeQuery();

			while (rs.next()) {

				int sNo = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String sex = rs.getString(4);
				Date dob = rs.getDate(5);
				String permanentAddress = rs.getString(6);
				String residenceAddress = rs.getString(7);
				String state = rs.getString(8);
				String city = rs.getString(9);
				int zipCode = rs.getInt(10);
				int areaCode = rs.getInt(11);
				String mobileNo = rs.getString(12);
				String email = rs.getString(13);

				CustomerInfo cinfo = new CustomerInfo(sNo, firstName, lastName, sex, dob, permanentAddress,
						residenceAddress, state, city, zipCode, areaCode, mobileNo, email);

				listOfCustomers.add(cinfo);
			}

		} catch (Exception e) {
			new CustomerException(1, e.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomerException(1, e.getMessage());
				}
			}
		}

		return listOfCustomers;
	}



}
