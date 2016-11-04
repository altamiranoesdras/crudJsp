package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.ConnectionProvider;
import models.User;

public class UserDao {

    private Connection conn;

    public UserDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addUser(User userBean) {
        try {
        	String sql = "INSERT INTO users(id, nombres,apellidos) VALUES (?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getNombres());
            ps.setString(3, userBean.getApellidos());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User userBean) {    	
    	try {
    		String sql = "UPDATE users SET nombres=?, apellidos=?" + " WHERE id=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, userBean.getNombres());
            ps.setString(2, userBean.getApellidos());            
            ps.setInt(3, userBean.getId());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<User> getAllUsers() {
    	List<User> users = new ArrayList<User>();
        try {
        	String sql = "SELECT * FROM users ORDER BY id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User userBean = new User();
                userBean.setId(rs.getInt("id"));
                userBean.setNombres(rs.getString("nombres"));
                userBean.setApellidos(rs.getString("apellidos"));                             
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
    	User userBean = new User();
        try {
        	String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setId(rs.getInt("id"));
            	userBean.setNombres(rs.getString("nombres"));
            	userBean.setApellidos(rs.getString("apellidos"));                           
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }
}