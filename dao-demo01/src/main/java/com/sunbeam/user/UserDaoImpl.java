package com.sunbeam.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements AutoCloseable, UserDao {
	private Connection con;
	public UserDaoImpl() throws Exception{
		con=DbUtil.connect();
	}
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
	@Override
	public User findById(int userId) throws Exception {

		String sql="SELECT * FROM users WHERE id=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, userId);
			
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()) {
				String name= rs.getString("name");
				String email=rs.getString("email");
				String passwd = rs.getString("passwd");
				String addr = rs.getString("addr");
				String role = rs.getString("role");
				Date birth = rs.getDate("birth");
				User user = new User(userId, name, passwd, email, addr, role, birth);

				return user;
				
			}
		}
		
	}return null;
	}
	
	public List<User> findAll() throws Exception {
		String sql = "SELECT * FROM users";
		List<User> list = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String passwd = rs.getString("passwd");
					String role = rs.getString("role");
					String addr = rs.getString("addr");
					Date birth = rs.getDate("birth");
					User user1 = new User(id, name, passwd, email, addr, role, birth);
					list.add(user1);
				}
			}
		} 
		return list;
	}
	
	@Override
	public User findByEmail(String email) throws Exception {
		String sql="SELECT * FROM users WHERE email=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					int id =rs.getInt("id");
					String name = rs.getString("name");
					String passwd = rs.getString("passwd");
					String addr = rs.getString("addr");
					String role = rs.getString("role");
					Date birth = rs.getDate("birth");
					User user1 = new User(id, name, passwd, email, addr, role, birth);
					return user1;

					
				}
			}
		}
		return null;
	}
	
	@Override
	public int save(User user) throws Exception {
		String sql = "INSERT INTO users (name, passwd, email, addr, role, birth) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddr());
			stmt.setString(5, user.getRole());
			stmt.setDate(6, user.getBitrh());
			
			int count =stmt.executeUpdate();
			return count;
			
		}
		
	}
	
	@Override
	public int update(User user) throws Exception {
		String sql =" UPDATE users SET name=?,passwd=?,email=?,addr=?,role=?,birth=? Where id=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPasswd());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddr());
			stmt.setString(5, user.getRole());
			stmt.setDate(6, user.getBitrh());
			stmt.setInt(7, user.getId());
			int count =stmt.executeUpdate();
			return count;
		}
		
	}
	@Override
	public int changePass(int userId, String newPasswd) throws Exception {
		String sql="Update users SET passwd=? WHERE id=?";
		
		try(PreparedStatement stmt= con.prepareStatement(sql)){
			stmt.setString(1, newPasswd);
			stmt.setInt(2, userId);
			
			int count =stmt.executeUpdate();
			return count;
			
		}
		
	}
	@Override
	public int deleteById(int userId) throws Exception {
		String sql ="DELETE FROM users WHERE id=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, userId);
			
			int count = stmt.executeUpdate();
			return count;
		}
		
	}
}

