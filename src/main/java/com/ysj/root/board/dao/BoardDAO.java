package com.ysj.root.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ysj.root.board.dto.BoardDTO;

public interface BoardDAO {
	
	public int saveBoard(BoardDTO dto);
	
	public ArrayList<BoardDTO> ShowBoardList(@Param("startBoardNum") int startBoardNum,@Param("endBoardNum") int endBoardNum);

	public BoardDTO SelectBoard(int boardId);
	
	public int countBoard();
	
	
	
}
