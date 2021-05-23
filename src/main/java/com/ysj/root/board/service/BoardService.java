package com.ysj.root.board.service;

import java.util.ArrayList;
import java.util.Map;

import com.ysj.root.board.dto.BoardDTO;

public interface BoardService {
	public ArrayList getAllPagingCount(); // DB에 저장된 개싯글 수를 반환해줌
	
	public int saveBoard(Map<String, Object> mapDto);
	
	public ArrayList<BoardDTO> ShowBoardList(int pageNum);
	
	public BoardDTO SelectBoard(int boardid);
	
	public boolean deleteBoard(int boardid); 

}
