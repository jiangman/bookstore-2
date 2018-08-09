package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookRequestVO;

public interface BookStorePersistService {

	public void updateBook(BookRequestVO request);
	public Long addBook(BookRequestVO request);
	public List<BookRequestVO> allBookList();
	public List<BookRequestVO> bookList(String bookName);
	public void deleteBook(BookRequestVO request);
	
}
