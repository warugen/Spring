package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;

public class BModifyService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto bDto = (BoardDto)map.get("boardDto");
		bDto.setBip((String)map.get("bip"));
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.modify(bDto);
		model.addAttribute("modifyResult", result);
	}

}
