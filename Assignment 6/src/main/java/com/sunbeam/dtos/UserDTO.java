package com.sunbeam.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	private int id;
	private String name;
	private String pass;
	private String email;
	private Date birth;
	private String addr;
	private String role;
}
