package com.tj.ch18.service;

import javax.servlet.http.HttpSession;

import com.tj.ch18.dto.Member;

public interface MemberService {
	public Member getMember(String mid);
	public int idConfirm(String mid);
	public int joimMember(Member member, HttpSession httpSession);
	public String loginCheck(String mid, String mpw, HttpSession httpSessioin);
	public int modifyMember(Member member);
}
