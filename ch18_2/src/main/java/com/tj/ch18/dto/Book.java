package com.tj.ch18.dto;

import java.sql.Date;

public class Book {
	
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;
	private String binfo;

	private int startRow;
	private int endRow;
	
	// 검색용 변수 추가
	private String schItem; // 검색하려고 선택된 항목 (책이름=btitle or 저자=bwriter)
	private String schWord; // 검색할 단어
	
	public String getSchItem() {
		return schItem;
	}
	public void setSchItem(String schItem) {
		this.schItem = schItem;
	}
	public String getSchWord() {
		return schWord;
	}
	public void setSchWord(String schWord) {
		this.schWord = schWord;
	}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	public String getBimg1() {
		return bimg1;
	}
	public void setBimg1(String bimg1) {
		this.bimg1 = bimg1;
	}
	public String getBimg2() {
		return bimg2;
	}
	public void setBimg2(String bimg2) {
		this.bimg2 = bimg2;
	}
	public String getBinfo() {
		return binfo;
	}
	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	@Override
	public String toString() {
		return "Book [bnum=" + bnum + ", btitle=" + btitle + ", bwriter=" + bwriter + ", brdate=" + brdate + ", bimg1="
				+ bimg1 + ", bimg2=" + bimg2 + ", binfo=" + binfo + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", schItem=" + schItem + ", schWord=" + schWord + "]";
	}
	
		
}
