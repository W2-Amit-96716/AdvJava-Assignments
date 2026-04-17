package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper userRowMapper;
	
	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, id);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		return list;
	}

	@Override
	public int save(User u) {
		String sql = "INSERT INTO users (id, name, pass, email, birth, addr, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int cnt = jdbcTemplate.update(sql, u.getId(), u.getName(), u.getPass(), u.getEmail(), u.getBirth(), u.getAddr(), u.getRole());
		return cnt;
	}

	@Override
	public int update(User u) {
		String sql = "UPDATE  users SET name=?, pass=?, email=?, birth=?, addr=?, role=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, u.getName(), u.getPass(), u.getEmail(), u.getBirth(), u.getAddr(), u.getRole(), u.getId());
		return cnt;
	}

	@Override
	public int updatePassword(int userId, String newPassword) {
		String sql = "UPDATE users SET pass=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, newPassword, userId);
		return cnt;
	}

	@Override
	public int deleteById(int userId) {
		String sql = "DELETE FROM users WHERE id=?";
		int cnt = jdbcTemplate.update(sql, userId);
		return cnt;
	}

}
