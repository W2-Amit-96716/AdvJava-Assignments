package com.sunbeam.daos;

import java.util.List;


import com.sunbeam.entities.User;


public interface UserDao {
	User findById(int id);
	List<User> findAll();
	int save(User u);
	int update(User u);
	int updatePassword(int userId, String newPassword);
	int deleteById(int userId);
}
