package com.sunbeam.cpmc;

import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try(BookDao bookDao=new BookDaoImpl()) {
			/*     Book findById(int bookId);
================================================================================
			System.out.println("Enter Book Id: ");
			int bookId=sc.nextInt();
			Book book=bookDao.findbyId(bookId);
			if(book==null)
				System.out.println("Book Not Exist.");
			else
				System.out.println("Book:"+book);
=====================================================================================				*/
			
			
			/*      List<Book> findAll(); 
========================================================================================			
			List<Book> bookList=bookDao.findAll();
			for(Book book:bookList) {
			
				System.out.println(book);
				}
========================================================================================				*/
			
			/*      List<Book> findByNameLike(String name);
========================================================================================
			System.out.println("Enter the book Likely Name :");
			String Bname=sc.nextLine();
			List<Book> book=bookDao.findByNameLike(Bname);
			if(book.isEmpty())
				System.out.println("Book Not exist");
			else
				for(Book b:book) {
					System.out.println(b);
				}
==========================================================================================				*/
			
			
			
		    /*    List<Book> findByAuthor(String author);
==========================================================================================
			System.out.println("Enter Author Name : ");
			String Bauthor=sc.nextLine();
			List<Book> book=bookDao.findByAuthor(Bauthor);
			if(book.isEmpty())
				System.out.println("Book Not exist");
			else
				for(Book b:book) {
					System.out.println(b);
				}
============================================================================================			*/
			
			/*       List<Book> findBySubject(String subject);
============================================================================================
			System.out.println("Enter Subject Name : ");
			String Bsubject=sc.nextLine();
			List<Book> book=bookDao.findBySubject(Bsubject);
			if(book.isEmpty())
				System.out.println("Book Not exist");
			else
				for(Book b:book) {
					System.out.println(b);
				}
=================================================================================================			*/
			
			/*   List<Book> findByPriceBetween(double minPrice, double maxPrice);
===================================================================================================
			System.out.println("Enter Minumum Price Range : ");
			double minprice=sc.nextDouble();
			System.out.println("Enter The Maximum Price Range: ");
			double maxprice=sc.nextDouble();
			List<Book> book=bookDao.findByPriceBetween(minprice, maxprice);
			if(book.isEmpty())
				System.out.println("Book Not exist");
			else
				for(Book b:book) {
					System.out.println(b);
				}
=====================================================================================================			*/
			
			/*           int save(Book b);
==================================================================================================
			System.out.println("Enter book Id:");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter book name:");
			String name = sc.nextLine();

			System.out.println("Enter author:");
			String author = sc.nextLine();

			System.out.println("Enter subject:");
			String subject = sc.nextLine();

			System.out.println("Enter price:");
			double price = sc.nextDouble();

			Book book = new Book(id, name, author, subject, price);

			int count = bookDao.save(book);

			if(count == 1)
			    System.out.println("Book Inserted Successfully");
			else
			    System.out.println("Insert Failed");
===============================================================================================*/
			
			
			/*   int update(Book b);
====================================================================================================
			System.out.println("Enter Book Id to update:");
			int id = sc.nextInt();
			sc.nextLine(); // flush

			System.out.println("Enter new name:");
			String name = sc.nextLine();

			System.out.println("Enter author:");
			String author = sc.nextLine();

			System.out.println("Enter subject:");
			String subject = sc.nextLine();

			System.out.println("Enter price:");
			double price = sc.nextDouble();

			Book book = new Book(id, name, author, subject, price);

			int count = bookDao.update(book);

			if(count == 1)
			    System.out.println("Book Updated Successfully");
			else
			    System.out.println("Book Not Found");
====================================================================================================			*/
			
			
			/*   int deleteById(int bookId);
====================================================================================================
			System.out.println("Enter Book Id to delete:");
			int id = sc.nextInt();

			int count = bookDao.deleteById(id);

			if(count == 1)
			    System.out.println("Book Deleted Successfully");
			else
			    System.out.println("Book Not Found");
======================================================================================================			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
