package com.sunbeam.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.user.DbUtil;
import com.sunbeam.user.User;

public class BookDaoImol implements AutoCloseable,BookDao{
	private Connection con;
	public BookDaoImol() throws Exception{
		con=DbUtil.connect();
	}
	
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
	@Override
	public Book findById(int bookId) throws Exception {

		String sql="SELECT * FROM books WHERE id=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, bookId);
			
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()) {
				String name= rs.getString("name");
				String author=rs.getString("author");
				String subject = rs.getString("subject");
				Double price = rs.getDouble("price");
				
				Book book = new Book(bookId, name, author, subject, price);

				return book;
				
			}
		}

		return null;
	}

	}
}
		


