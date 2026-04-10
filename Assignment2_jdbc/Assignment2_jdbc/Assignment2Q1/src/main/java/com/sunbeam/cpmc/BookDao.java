package com.sunbeam.cpmc;

import java.util.List;

public interface BookDao extends AutoCloseable{
	Book findbyId(int id) throws Exception;
	List<Book> findAll() throws Exception;
	List<Book> findByNameLike(String name) throws Exception;
	List<Book> findByAuthor(String author) throws Exception;
	List<Book> findBySubject(String subject) throws Exception;
	List<Book> findByPriceBetween(double minPrice, double maxPrice) throws Exception;
	int update(Book b) throws Exception;
	int save(Book b) throws Exception;
	int deleteById(int bookId) throws Exception;

}
