package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BookStorePersistDao;
import com.example.demo.model.BookRequestVO;
import com.example.demo.service.BookStorePersistService;

@Service
public class BookStorePersistServiceImpl implements BookStorePersistService {

	@Autowired
	BookStorePersistDao bookStorePersistDao;
	
	@Override
	public Long addBook(BookRequestVO request) {
		// TODO Auto-generated method stub
		Long savedBookId = bookStorePersistDao.addBook(request);
		return savedBookId;
	}
	
	public List<BookRequestVO> allBookList() {
		return bookStorePersistDao.allBookList();
	}

	@Override
	public List<BookRequestVO> bookList(String bookName) {
		// TODO Auto-generated method stub
		return bookStorePersistDao.bookList(bookName);
	}

	@Override
	public void updateBook(BookRequestVO request) {
		bookStorePersistDao.updateBook(request);
		
	}
	
	public void deleteBook(BookRequestVO request)
	{
		bookStorePersistDao.deleteBook(request);
	}
	
}
