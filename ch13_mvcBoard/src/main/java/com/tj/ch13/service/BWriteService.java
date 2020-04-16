package com.tj.ch13.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch13.dao.BoardDao;
import com.tj.ch13.dto.BoardDto;

public class BWriteService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	// model안의 attribute값을 추출하기위해 map화시킨다.
		BoardDto bDto = (BoardDto)map.get("boardDto");
		// 방법1
		//HttpServletRequest request = (HttpServletRequest)map.get("request");
		//bDto.setBip(request.getRemoteAddr());
		// 방법2
		bDto.setBip((String)map.get("bip"));
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.write(bDto);
		model.addAttribute("writeResult", result);
	}
}
