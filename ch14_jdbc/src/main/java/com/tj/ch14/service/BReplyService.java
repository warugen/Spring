package com.tj.ch14.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;

public class BReplyService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardDto dto = (BoardDto) map.get("boardDto");
		// bgroup, bstep, bindent : 원글에 대한 정보는 자동으로 Controller에서 boardDto에 담겨오기때문에 따로 처리할필요없음
		/*
		dto.setBgroup(Integer.parseInt(request.getParameter("bgroup")));
		dto.setBstep(Integer.parseInt(request.getParameter("bstep")));
		dto.setBindent(Integer.parseInt(request.getParameter("bindent")));
		*/
		dto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("replyResult", bDao.reply(dto));
	}

}
