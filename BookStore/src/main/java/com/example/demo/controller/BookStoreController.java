package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookListResponseVO;
import com.example.demo.model.BookRequestVO;
import com.example.demo.service.BookStorePersistService;

@RestController
@RequestMapping("bookstore")
public class BookStoreController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BookStorePersistService bookStorePersistService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity addBook(@RequestBody BookRequestVO request) throws Exception {

		try {
			Long response = bookStorePersistService.addBook(request);
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Excetion encountered:: {}", e.getMessage());
			String response = e.getMessage();
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity updateBook(@RequestBody BookRequestVO request) throws Exception {

		try {
			bookStorePersistService.updateBook(request);
			return new ResponseEntity("updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Excetion encountered:: {}", e.getMessage());
			String response = e.getMessage();
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity allBookList() {

		BookListResponseVO responseWrapper = new BookListResponseVO();
		try {
			List<BookRequestVO> bookList = bookStorePersistService.allBookList();
			responseWrapper.setBookList(bookList);
			responseWrapper.setTotalCount(bookList.size());
			return new ResponseEntity(responseWrapper, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Excetion encountered:: {}", e.getMessage());
			String response = e.getMessage();
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/book/{bookName}", method = RequestMethod.GET)
	public ResponseEntity bookList(@PathVariable String bookName) {

		BookListResponseVO responseWrapper = new BookListResponseVO();
		try {
			List<BookRequestVO> bookList = bookStorePersistService.bookList(bookName);
			responseWrapper.setBookList(bookList);
			responseWrapper.setTotalCount(bookList.size());
			return new ResponseEntity(responseWrapper, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Excetion encountered:: {}", e.getMessage());
			String response = e.getMessage();
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity deleteBook(@RequestBody BookRequestVO request) throws Exception {

		try {
			 	bookStorePersistService.deleteBook(request);
			 	return new ResponseEntity("Successfully Delete", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Excetion encountered:: {}", e.getMessage());
			String response = e.getMessage();
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
