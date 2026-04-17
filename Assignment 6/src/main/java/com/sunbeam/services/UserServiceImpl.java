package com.sunbeam.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO findUserById(int id) {
		User entity = userDao.findById(id);
		if(entity != null) {
			UserDTO dto = modelMapper.map(entity, UserDTO.class);
			return dto;
		}
		return null;
	}
	
	public List<UserDTO> findAllUsers() {
		List<User> entities = userDao.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		for (User entity : entities) {
			UserDTO dto = modelMapper.map(entity, UserDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public int saveUser(UserDTO dto) {
		User entity = modelMapper.map(dto, User.class);
		int cnt = userDao.save(entity);
		return cnt;
	}
	
	public UserDTO updateUser(int userId, UserDTO dto) {
		User entity = modelMapper.map(dto, User.class);
		entity.setId(userId);
		userDao.update(entity);
		return modelMapper.map(entity, UserDTO.class);
	}
	
	public int deleteUser(int userId) {
		return userDao.deleteById(userId);
	}
	
	public int updateUserPass(int userId, String newPassword) {
		return userDao.updatePassword(userId, newPassword);
	}
}
