package com.tj.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18.dto.Book;
import com.tj.ch18.service.BookService;
import com.tj.ch18.util.Paging;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(params="method=registerForm")
	public String registerForm() {
		return "book/registerForm";
	}
	
	@RequestMapping(params="method=register")
	public String register(Book book, MultipartHttpServletRequest mRequest, Model model) {
		int result = bookService.registerBook(mRequest, book);
		model.addAttribute("registerResult", result);
		return "book/registerFrom";
	}
	
	@RequestMapping(params="method=list")
	public String list(String pageNum, Model model, Book book) {
		Paging paging = new Paging(bookService.cntBook(book), pageNum, 3, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		System.out.println("컨트롤러 book : "+book);
		model.addAttribute("paging", paging);
		model.addAttribute("list", bookService.bookList(book));
		return "book/list";
	}
	
	@RequestMapping(params="method=detail")
	public String detail(Model model, int bnum) {
		model.addAttribute("detail", bookService.getBook(bnum));
		return "book/bookDetail";
	}
	
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(int bnum, String pageNum, Model model) {
		model.addAttribute("modify", bookService.getBook(bnum));
		return "book/modifyForm";
	}
	
	@RequestMapping(params="method=modify")
	public String modify(MultipartHttpServletRequest mRequest, String pageNum) {
		bookService.modifyBook(mRequest);
		return "redirect:book.do?method=list&pageNum="+pageNum;
	}
}
