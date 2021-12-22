package com.greenqbit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {

	public Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// 1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "dbuser");

		return conn;
	}
}
