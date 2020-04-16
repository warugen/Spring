package com.tj.ch18.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18.dto.Book;

public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public Book getBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	public int modifyBook(MultipartHttpServletRequest mRequest);
	public int cntBook();
}
