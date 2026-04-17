package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.User;

@Component
public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String pass = rs.getString("pass");
		String email = rs.getString("email");
		Date birth = rs.getDate("birth");
		String addr = rs.getString("addr");
		String role = rs.getString("role");
		return new User(id, name, pass, email, birth, addr, role);
	}
	
}
