package com.javabros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javabros.model.Customer;

public class DBUtil {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/";
	private final String DB_NAME = "test";
	private final String USER = "root";
	private final String PASSWORD = "dow123";
	private Connection conn;
	private Statement statement;

	public DBUtil() {
		connect();
	}

	private void connect() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
			statement = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (statement != null)
				statement.close();

			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addCustomer(Customer customer) {
		try {
			int i = statement
					.executeUpdate("INSERT INTO customer (c_fname, c_lname, c_city, c_zipcode) VALUES ('"
							+ customer.getfName()
							+ "', '"
							+ customer.getlName()
							+ "', '"
							+ customer.getCity()
							+ "', )");
			if (i == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int deleteCustomer(int id) {
		try {
			int i = statement.executeUpdate("DELETE FROM customer where c_id="
					+ id);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int updateCity(int id, String name) {
		try {
			int i = statement.executeUpdate("UPDATE customer set c_city='"
					+ name + "' where c_id=" + id);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<Customer> getCustomers() {
		try {
			List<Customer> customers = new ArrayList<>();
			ResultSet rs = statement.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				customers.add(new Customer(rs.getInt("c_id"), rs
						.getString("c_fname"), rs.getString("c_lname"), rs
						.getString("c_city"), rs.getInt("c_zipcode")));
			}
			return customers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
