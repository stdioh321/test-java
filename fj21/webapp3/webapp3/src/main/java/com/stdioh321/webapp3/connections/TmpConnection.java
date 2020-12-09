package com.stdioh321.webapp3.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TmpConnection {
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tmp", "root", "includestdioh");
	}
}
