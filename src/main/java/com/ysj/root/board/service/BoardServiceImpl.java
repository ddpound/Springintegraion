package com.ysj.root.board.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.root.board.dao.BoardDAO;
import com.ysj.root.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO mapper;
	
	private int allPagingCount = 0; // 총 페이지 수
	
	@Override
	public ArrayList getAllPagingCount() {
		ArrayList numList = new ArrayList();
		
		for(int i=1; i<=allPagingCount; i++) {
			numList.add(i);
		}
		
		return numList;
	}
	
	// 세이브 포인트
	@Override
	public int saveBoard(Map<String, Object> mapDto) {
		BoardDTO dto = new BoardDTO();
		
		String title = (String)mapDto.get("title");
		String contents =  (String)mapDto.get("contents");
		
		
		// 널도아니고 그렇다고 값이 있는것도 아니고 그래서 "" <= 이렇게 빈값을 했음
		if(title.equals("") ||contents.equals("")) {
			return -1; //글이나 내용이 하나도 없다면 -1리턴
		}
		
		dto.setWriteuser((String)mapDto.get("writeuser"));
		dto.setContents((String)mapDto.get("contents"));
		//System.out.println(dto.getContents());
		dto.setTitle((String)mapDto.get("title"));
		
		dto.setHit(0);
		long nowdate = System.currentTimeMillis();
		dto.setWritedate(new Date(nowdate));
		mapper.saveBoard(dto); // 저장줄
		return 1;
	}
	
	//단순히 페이지 전부를 가져오는 메소드
	// pageNum => 요구하는 몇번의 페이지
	@Override
	public ArrayList<BoardDTO> ShowBoardList(int pageNum) {
		int totalBoard = mapper.countBoard(); // 현재 저장되어있는 페이지 갯수
		int onePageboardCount = 8;// 한페이지에 보여줄 개싯글 수
		
		int lastPage = 0; // 마지막 페이지 번호
		int startBoardNum = 1; // 시작 게싯글 번호 무조건 1번이여야함
		int endBoardNum = onePageboardCount; // 마지막 게싯글 번호
		
		System.out.println("총 보드의 갯수: "+ totalBoard);
		allPagingCount = totalBoard/onePageboardCount;
		System.out.println("페이징 전: "+allPagingCount);
		if(totalBoard % onePageboardCount >= 0) {
			allPagingCount = allPagingCount+1; // 마지막 페이지 적용
			lastPage = allPagingCount;
		}
		System.out.println("페이징 후: "+allPagingCount);
		
		if(pageNum==1) {
			// 첫번째 페이지 일때 기본세팅에서 따로 할껀 없다
			
		}else if(pageNum == lastPage) {
			// 마지막 페이지라는 의미니깐
			startBoardNum+=(onePageboardCount*(lastPage-1));
			int remainBoard =(pageNum*onePageboardCount)-totalBoard;
			// ex) 총 페이지수 - 8*4 = 2가 남음
			endBoardNum = (pageNum*onePageboardCount)-remainBoard;
		}else {
			startBoardNum+=onePageboardCount;
			endBoardNum+=onePageboardCount;
		}
		System.out.println(startBoardNum+" ~ "+endBoardNum);
		
		return mapper.ShowBoardList(startBoardNum,endBoardNum);
	}

	@Override
	public BoardDTO SelectBoard(int boardid) {
		BoardDTO dto = new BoardDTO();
		dto = mapper.SelectBoard(boardid);
		int intAddHit = dto.getHit()+1;
		
		dto.setHit(intAddHit);
		
		mapper.addHit(boardid,intAddHit);
		
		
		return dto;
	}

	@Override
	public boolean deleteBoard(int boardid) {
		int result = mapper.deleteBoard(boardid);
		
		if(result==1) {
			return true;
			// 올바르게 삭제한경우 1을 반환하도록 하자
		}
		return false;
	}

}
