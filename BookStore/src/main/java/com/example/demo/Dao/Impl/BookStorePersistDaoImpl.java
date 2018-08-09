package com.example.demo.Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Dao.BookStorePersistDao;
import com.example.demo.entity.Book;
import com.example.demo.model.BookRequestVO;

@Repository
@Transactional
public class BookStorePersistDaoImpl implements BookStorePersistDao  {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Long addBook(BookRequestVO request) {
		Book object = new Book();
		Session session = entityManager.unwrap(Session.class);
		BeanUtils.copyProperties(request, object);
		Long id = (Long) session.save(object);
		return id;
	}

	@SuppressWarnings("unchecked")
	public List<BookRequestVO> allBookList(){
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Book.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookRequestVO> bookList(String bookName) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Book.class);
		criteria.add(Restrictions.ilike("bookName", bookName, MatchMode.ANYWHERE));
		return criteria.list();
	}

	@Override
	public void updateBook(BookRequestVO request) {
		
		Book object = new Book();
		Session session = entityManager.unwrap(Session.class);
		BeanUtils.copyProperties(request, object);
		session.update(object);
	}

	@Override
	public void deleteBook(BookRequestVO request) {
		Book object = new Book();
		Session session = entityManager.unwrap(Session.class);
		object = (Book) session.get(Book.class, request.getBookId());
		session.delete(object);
	}
	
	
	
}
