package com.tj.ch14.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;

public class BListService implements BService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	// model을 Map화 시킨다.
		String pageNum = (String) map.get("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("list", bDao.list(startRow, endRow));
		int orderNum = startRow;	// 출력될 순번
		int totCnt = bDao.getBoardTotCnt();	// 전체 글갯수
		int inverseNum = totCnt - startRow + 1;	// 출력될 역순 번호
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
		startPage = currentPage - (currentPage-1) % BLOCKSIZE;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		// pageNum이나 currentPage둘중에 하나를 넣어준다.
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
	}

}
