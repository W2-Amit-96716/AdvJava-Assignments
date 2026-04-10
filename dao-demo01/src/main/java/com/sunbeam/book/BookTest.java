package com.sunbeam.book;

import java.util.Scanner;

import com.sunbeam.user.UserDao;
import com.sunbeam.user.UserDaoImpl;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(BookDao bookDao = new BookDaoImol()){
			
			System.out.print("Enter User Id: ");
			int bookId = sc.nextInt();
			Book book = bookDao.findById(bookId);
			if(book == null)
				System.out.println("Book Not Found.");
			else
				System.out.println("Found " + book);
			
//		

}
