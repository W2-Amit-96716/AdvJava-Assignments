package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.UserDTO;
import com.sunbeam.entities.User;
import com.sunbeam.services.UserServiceImpl;

@RequestMapping("/users")
@RestController
public class UserRestController {
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping
	public Resp<?> getAllBooks() {
		List<UserDTO> list = userService.findAllUsers();
		return Resp.success(list);
	}
	
	@GetMapping("/{id}")
	public Resp<?> getUserById(@PathVariable int id) {
		UserDTO u = userService.findUserById(id);
		if(u != null)
			return Resp.success(u);
		return Resp.error("User Not Found");
	}
	
	@PostMapping
	public Resp<?> addUser(@RequestBody UserDTO u) {
		int cnt = userService.saveUser(u);
		return Resp.success(cnt);
	}
	
	@PutMapping("/{id}")
	public Resp<?> updateUser(@PathVariable("id") int userId, @RequestBody UserDTO dto) {
		System.out.println("dto");
		dto.setId(userId);
		UserDTO user = userService.updateUser(userId, dto);
		System.out.println("dto");
		return Resp.success(user);
		//System.out.println("dto");
	}
	
	@PatchMapping("/{id}")
	public Resp<?> changePassword(@PathVariable("id") int userId, @RequestBody String newPassword) {
		userService.updateUserPass(userId, newPassword);
		return Resp.success("Password Updated");
	}
	
	@DeleteMapping("/{id}")
	public Resp<?> deleteUser(@PathVariable("id") int userId) {
		int cnt = userService.deleteUser(userId);
		return Resp.success(cnt);
	}
}
