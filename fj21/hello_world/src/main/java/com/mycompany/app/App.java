package com.mycompany.app;

import com.mycompany.entities.User;
import com.mycompany.repositories.ConnectionFactory;
import com.mycompany.repositories.UserDao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try (Connection conn = ConnectionFactory.getConnection()) {
			System.out.println("Connection CREATED");
			/*
			 * PreparedStatement psInsert =
			 * conn.prepareStatement("INSERT INTO users(name,created_at) VALUE(?,?)");
			 * psInsert.setString(1, "John_" + Instant.now().toEpochMilli());
			 * psInsert.setTimestamp(2, Timestamp.from(Instant.now()));
			 * 
			 * psInsert.execute();
			 */

			UserDao userDao = new UserDao();
			User u = new User();
			u.setId(7L);

			u.setName("Luigi_" + Instant.now().toEpochMilli());

			u.setCreated_at(Timestamp.from(Instant.now()));
			userDao.putUser(u);

			var us = userDao.getUserById(14L);
			if (!Objects.isNull(us)) {
				System.out.println(us.getCreated_at());
			}
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp d = rs.getTimestamp("created_at");
				String tmpDate = null;
				if (!Objects.isNull(d)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					tmpDate = sdf.format(d);
				}
				System.out.format("%s - %s - %s\n", rs.getInt("id"), rs.getString("name"), tmpDate);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
