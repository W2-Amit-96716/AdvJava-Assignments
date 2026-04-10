package com.sunbeam.book;

interface BookDao extends AutoCloseable{
    Book findById(int bookId) throws Exception;


}
