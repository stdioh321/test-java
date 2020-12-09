package com.stdioh321.webapp3.repositories;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.stdioh321.webapp3.connections.TmpConnection;
import com.stdioh321.webapp3.entities.User;

public class UserDao {
	Connection conn;

	public UserDao() throws SQLException {
		conn = TmpConnection.getConnection();
	}

	public List<User> getAll() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User u = new User();
			u.setName(rs.getString("name"));
			u.setCreatedAt(rs.getTimestamp("created_at"));
			u.setId(rs.getLong("id"));
			users.add(u);
		}
		return users;
	}
}
