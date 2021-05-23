package com.ysj.root.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ysj.root.board.dto.BoardDTO;

public interface BoardDAO {
	
	public int saveBoard(BoardDTO dto);
	
	public ArrayList<BoardDTO> ShowBoardList(@Param("startBoardNum") int startBoardNum,
			@Param("endBoardNum") int endBoardNum);

	public BoardDTO SelectBoard(int boardId);
	
	public int countBoard();
	
	// delete 삭제 후, 삭제된 row만큼 반환, 하나도 삭제시키지 못했다면 0
	public int deleteBoard(int boardid);
	
	public void addHit(@Param("boardid") int boardid ,@Param("intAddHit") int intAddHit);
	
}
