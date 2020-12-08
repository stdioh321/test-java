package com.mycompany.repositories;

import com.mycompany.entities.User;

import java.sql.*;
import java.util.Objects;

public class UserDao {
    private Connection conn;

    public User getUserById(Long id) throws SQLException, ClassNotFoundException {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE id=? LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        if(!rs.next()) return null;
        User u = new User();
        u.setId(rs.getLong("id"));
        u.setName(rs.getString("name"));
        u.setCreated_at(rs.getTimestamp("created_at"));
        return u;

    }

    public boolean putUser(User user) throws SQLException, ClassNotFoundException {
        boolean res = false;
        this.conn = ConnectionFactory.getConnection();
        if (Objects.isNull(user.getId())) {
            String sql = "INSERT INTO users(name, created_at) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setTimestamp(2, user.getCreated_at());
            res = ps.execute();
        } else {
            String sql = "UPDATE users SET id=?,name=?,created_at=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setTimestamp(3, user.getCreated_at());
            ps.setLong(4, user.getId());
            res = ps.execute();
        }

        conn.close();
        return res;
    }
}
