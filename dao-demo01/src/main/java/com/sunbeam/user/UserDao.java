package com.sunbeam.user;

import java.util.List;

import com.google.protobuf.Extension;

public interface UserDao extends AutoCloseable{
	
	User findById(int userId) throws Exception;
	List<User> findAll() throws Exception;
	User findByEmail(String email) throws Exception;
	int save(User user) throws Exception;
	int update(User user) throws Exception;
	int changePass(int userId, String newPasswd) throws Exception;
	int deleteById(int userId) throws Exception;
	
}
