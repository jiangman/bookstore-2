package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.example.demo.model.BookRequestVO;
import com.example.demo.service.BookStorePersistService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	BookStorePersistService bookStorePersistService;
	
	@Test
	public void addBook() {
		BookRequestVO obj = new BookRequestVO();
		obj.setBookName("new_Book_from_test");
		obj.setDescription("Description");
		obj.setCost(121L);
		Long id = bookStorePersistService.addBook(obj);
		Assert.isTrue(id > 0, "Book Added Successfully");
		}
	
	@Test
	public void listAllBook() {
		List<BookRequestVO> bookList = bookStorePersistService.allBookList();
		Assert.notEmpty(bookList, "getAllBookList Successfull");
	}
	
	@Test
	public void getBookByName() {
		String bookName = "book";
		List<BookRequestVO> bookList = bookStorePersistService.bookList(bookName);
		Assert.notEmpty(bookList, "getBookByName Successfull");
	}
	
	@Test
	public void updateBook() {
		BookRequestVO obj = new BookRequestVO();
		obj.setBookId(1L);
		obj.setBookName("new_Book_from_test1");
		obj.setDescription("Description");
		obj.setCost(121L);
		Long id = bookStorePersistService.addBook(obj);
		Assert.hasText("updated Successfully", "update works fine");
		}
	
	@Test
	public void deleteBook() {
		BookRequestVO obj = new BookRequestVO();
		obj.setBookId(1L);
		obj.setBookName("new_Book_from_test1");
		obj.setDescription("Description");
		obj.setCost(121L);
		Long id = bookStorePersistService.addBook(obj);
		Assert.hasText("Successfully Delete", "delete works fine");
		}

}
