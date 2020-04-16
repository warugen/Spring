package com.tj.ch18.dao;

import com.tj.ch18.dto.Member;

public interface MemberDao {
	public int idconfirm(String mid);
	public int joinMember(Member member);
	public Member getMember(String mid);
	public int modifyMember(Member member);
}
