package com.ysj.root.board.service;

import java.util.ArrayList;
import java.util.Map;

import com.ysj.root.board.dto.BoardDTO;

public interface BoardService {
	public ArrayList getAllPagingCount();
	
	public int saveBoard(Map<String, Object> mapDto);
	
	public ArrayList<BoardDTO> ShowBoardList(int pageNum);
	
	public BoardDTO SelectBoard(int boardid);

}
