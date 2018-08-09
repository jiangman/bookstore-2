package com.example.demo.model;

import java.util.List;

public class BookListResponseVO {

	Integer totalCount;
	List<BookRequestVO> bookList;
	
	public List<BookRequestVO> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookRequestVO> bookList) {
		this.bookList = bookList;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
}
