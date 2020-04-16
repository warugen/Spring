package com.tj.ch18.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18.dao.BookDao;
import com.tj.ch18.dto.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	String backupPath = "D:\\mega_IT\\source\\8_Spring\\ch18\\src\\main\\webapp\\bookImgFileUpload/";

	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(Book book) {
		return bookDao.bookList(book);
	}

	@Override
	public Book getBook(int bnum) {
		return bookDao.getBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"", ""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				// 파일 첨부한경우
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 서버에 같은 파일명이 있을경우 첨부한 파일 이름을 변경
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버 파일 : " + uploadPath+bimg[idx]);
					System.out.println("백업 파일 : " + backupPath+bimg[idx]);
					boolean result = filecopy(uploadPath+bimg[idx], backupPath+bimg[idx]); 
					System.out.println(result == true? idx+"번째 복사성공" : idx+"번째 복사실패");
				} catch (IOException e) {
					System.out.println("첨부파일 실패" + e.getMessage());
				}
			} else {
				bimg[idx] = "";
			}
			idx++;
		}
		System.out.println("Book Img1 : "+bimg[0]);
		System.out.println("Book Img2 : "+bimg[1]);
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		System.out.println("BookServiceImpl : "+ book.toString());
		return bookDao.registerBook(book);
	}
	

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"", ""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				// 파일 첨부한경우
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 서버에 같은 파일명이 있을경우 첨부한 파일 이름을 변경
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버 파일 : " + uploadPath+bimg[idx]);
					System.out.println("백업 파일 : " + backupPath+bimg[idx]);
					boolean result = filecopy(uploadPath+bimg[idx], backupPath+bimg[idx]); 
					System.out.println(result == true? idx+"번째 복사성공" : idx+"번째 복사실패");
				} catch (IOException e) {
					System.out.println("첨부파일 실패" + e.getMessage());
				}
			} else {
				bimg[idx] = "";
			}
			idx++;
		}
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBinfo(mRequest.getParameter("binfo"));
		book.setBimg1(bimg[0]);//첫번째 첨부한 파일이름
		book.setBimg2(bimg[1]);//두번째 첨부한 파일이름
		return bookDao.modifyBook(book);
	}

	@Override
	public int cntBook(Book schItem) {
		return bookDao.cntBook(schItem);
	}
	
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		
		FileInputStream is = null;
		FileOutputStream os = null;
		
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[1024*1024*10];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
				
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return isCopy;
	}	

}
