package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl implements AutoCloseable,BookDao{
	private Connection con;
	
	public BookDaoImpl() throws Exception {
		con=DbUtil.connect();
	}
	
	@Override
	public void close() throws Exception {
		if(con !=null)
			con.close();
	}


	@Override
	public Book findbyId(int BookId) throws Exception {
		// TODO Auto-generated method stub
		
		
		String sql="SELECT * FROM books WHERE id=?";
		
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1, BookId);
			
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
				
				String name=rs.getString("name");
				String author=rs.getString("author");
				String subject=rs.getString("subject");
				double price=rs.getDouble("price");
				Book book=new Book(BookId,name,author,subject,price);
				return book;
				
				
				}
			}
		}
		return null;
	}

	

	@Override
	public List<Book> findAll() throws Exception {
		String sql="SELECT * FROM books";
		List<Book> list=new ArrayList<>();
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					Book book=new Book(id,name,author,subject,price);
					list.add(book);
					
				}
			}
		}
		return list;
	}

	@Override
	public List<Book> findByNameLike(String Bname) throws Exception  {
		String sql="SELECT * FROM books WHERE name LIKE ?";
		List<Book> list=new ArrayList<>();
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			stmt.setString(1,"%"+Bname+"%");
			
			try(ResultSet rs=stmt.executeQuery()) {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					Book book=new Book(id,name,author,subject,price);
					list.add(book);
				}
				
			}
		}


		return list;
	}

	@Override
	public List<Book> findByAuthor(String Bauthor) throws Exception {
		String sql="SELECT * FROM books WHERE author=?";
		List<Book> list=new ArrayList<>();
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			stmt.setString(1, Bauthor);
			
			try(ResultSet rs=stmt.executeQuery()) {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					Book book=new Book(id,name,author,subject,price);
					list.add(book);
				}
			}
		}return list;
		
	}

	@Override
	public List<Book> findBySubject(String Bsubject) throws Exception {
		String sql="SELECT * FROM books WHERE subject=?";
		List<Book> list=new ArrayList<>();
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			stmt.setString(1, Bsubject);
			
			try(ResultSet rs=stmt.executeQuery()) {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					Book book=new Book(id,name,author,subject,price);
					list.add(book);
				}
			}
		}
		return list;
	}

	@Override
	public List<Book> findByPriceBetween(double minPrice, double maxPrice) throws Exception {
		String sql="SELECT * FROM books WHERE price BETWEEN ? AND ?";
		List<Book> list=new ArrayList<>();
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			stmt.setDouble(1, minPrice);
			stmt.setDouble(2, maxPrice);
			
			try(ResultSet rs=stmt.executeQuery()) {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price=rs.getDouble("price");
					Book book=new Book(id,name,author,subject,price);
					list.add(book);
				}
			}
		}
		return list;
	}

	@Override
	public int update(Book b) throws Exception {
		String sql="UPDATE books SET name=?, author=?,subject=?,price=? WHERE id=?";
		try(PreparedStatement stmt=con.prepareStatement(sql)) {
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			
			int count=stmt.executeUpdate();
			return count;
		}
		
	}

	@Override
	public int save(Book b) throws Exception {
		String sql = "INSERT INTO books (id,name, author, subject, price) VALUES (?,?, ?, ?, ?)";
	    try(PreparedStatement stmt = con.prepareStatement(sql)) {
	    	stmt.setInt(1, b.getId());
	        stmt.setString(2, b.getName());
	        stmt.setString(3, b.getAuthor());
	        stmt.setString(4, b.getSubject());
	        stmt.setDouble(5, b.getPrice());
	        int count = stmt.executeUpdate(); 
	        return count;
	    }
		
	}

	@Override
	public int deleteById(int bookId) throws Exception {
		String sql = "DELETE FROM books WHERE id = ?";

	    try(PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setInt(1, bookId);

	        int count = stmt.executeUpdate(); // rows deleted
	        return count;
	    }
	}

}
