package com.sunbeam.user;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class DaoDemo01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(UserDao userDao = new UserDaoImpl()){
			
//			System.out.print("Enter User Id: ");
//			int userId = sc.nextInt();
//			User user = userDao.findById(userId);
//			if(user == null)
//				System.out.println("User Not Found.");
//			else
//				System.out.println("Found " + user);
			
//			List<User> userList= userDao.findAll();
//			for(User user : userList) {
//				System.out.println(user);
//			}
			//---------------------------------------------
			
//			System.out.println("Enter email to find ");
//			String email =sc.next();
//			
//			User user = userDao.findByEmail(email);
//			if(email==null) 
//				System.out.println("user not found");
//			else 
//				System.out.println(user);
			//----------------------------------------------
//			
//			System.out.print("Enter Name: ");
//			String name = sc.next();
//			System.out.print("Enter Passwd: ");
//			String passwd = sc.next();
//			System.out.print("Enter Email: ");
//			String email = sc.next();
//			System.out.print("Enter Address: ");
//			String addr = sc.next();
//			System.out.print("Enter Birth (yyyy-MM-dd): ");
//			String birthStr = sc.next();
//			System.out.print("Enter Role: ");
//			String role = sc.next(); 
//			Date birth = Date.valueOf(birthStr);
//			User user = new User(0, name, passwd, email, addr, role, birth);
//			int count = userDao.save(user);
//			System.out.println("User Inserted: " + count);
			//-----------------------------------------------------------
//			System.out.print("Enter User Id to modify: ");
//			int userId = sc.nextInt();
//			System.out.print("Enter Name: ");
//			String name = sc.next();
//			System.out.print("Enter Passwd: ");
//			String passwd = sc.next();
//			System.out.print("Enter Email: ");
//			String email = sc.next();
//			System.out.print("Enter Address: ");
//			String addr = sc.next();
//			System.out.print("Enter Birth (yyyy-MM-dd): ");
//			String birthStr = sc.next();
//			System.out.print("Enter Role: ");
//			String role = sc.next(); 
//			Date birth = Date.valueOf(birthStr);
//			User user = new User(userId, name, passwd, email, addr, role, birth);
//			int count = userDao.update(user);
//			System.out.println("User Updated: " + count);
			//--------------------------------------------------------------
			
//			System.out.println("enter id to update pass");
//			int userId = sc.nextInt();
//			
//			System.out.println("enter new password");
//			String passwd =sc.next();
//			int count =userDao.changePass(userId, passwd);
//			System.out.println("Password updated "+count);
			//----------------------------------------------
			System.out.println("Enter id to delete ");
			int userId=sc.nextInt();
			
			int count =userDao.deleteById(userId);
			System.out.println("user deleted successfully");
		}
			catch (Exception e) {
				e.printStackTrace();
		}
	}

}
