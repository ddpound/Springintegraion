package com.ysj.root.board.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysj.root.board.dto.BoardDTO;
import com.ysj.root.board.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired 
	BoardService bs;
	
	@RequestMapping(value = {"/", "boardPage" })
	public String index(Model model , @RequestParam(value = "pageNum" , required = false, defaultValue = "1") int pageNum ) {
		System.out.println(pageNum);
		model.addAttribute("boardList",bs.ShowBoardList(pageNum));
		model.addAttribute("allPagingCount",bs.getAllPagingCount());
		
		return "index";
	}

	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}

	@PostMapping(value = "saveBoard", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String saveBoard(@RequestBody Map<String, Object> mapDto) {
		System.out.println(mapDto.get("title"));
		System.out.println(mapDto.get("writeuser"));
		
		int result = bs.saveBoard(mapDto);
		System.out.println("result 결과값"+result);
		if(result ==1) {
			return "{\"saveResult\" : true}";
		}else if(result == -1) {
			return "{\"saveResult\" : \"noContents\"}";
		}
		
		return "{\"saveResult\" : false}";
	}
	
	@GetMapping("showboard")
	public String showBoard(@RequestParam("boardid") int boardid, Model model) {
		System.out.println(boardid);
		//조회수 추가부분
		
		model.addAttribute("selectboard",bs.SelectBoard(boardid));
		
		return "board/selectBoardView";
	}
	
	@DeleteMapping("deleteBoard")
	@ResponseBody
	public String deleteBoard(@RequestParam("boardId")int id ,Model model) {
		System.out.println(id);
		
		if(bs.deleteBoard(id)) {
			return "{\"result\" : true}";
		}
		return "{\"result\" : false}";
		
	}
	
	
	
	

}
