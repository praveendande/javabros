package com.tutor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tutor.entity.Customer;

public class DBUtil {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DB_NAME = "test";
	private final String USER = "root";
	private final String PASSWORD = "12345";
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

	public void close() {
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
							+ customer.getFirstName()
							+ "', '"
							+ customer.getLastName()
							+ "', '"
							+ customer.getCity()
							+ "', "
							+ customer.getZipcode() + ")");
			if (i == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Customer> list() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			ResultSet rs = statement.executeQuery("select * from customer");
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

	public void dropCustomerTable() {
		try {
			statement.executeUpdate("drop table customer");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCustomerTable() {
		try {
			statement.executeUpdate("CREATE TABLE customer ("
					+ "c_id INT NOT NULL AUTO_INCREMENT,"
					+ "c_fname VARCHAR(50) NOT NULL,"
					+ "c_lname VARCHAR(50) NOT NULL,"
					+ "c_city VARCHAR(100) NOT NULL,"
					+ "c_zipcode INT NOT NULL," + "PRIMARY KEY (c_id))");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
