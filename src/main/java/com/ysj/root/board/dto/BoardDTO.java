package com.ysj.root.board.dto;

import java.sql.Date;

public class BoardDTO {
	private int boardId;
	private String title;
	private String contents;
	private Date writedate;
	private int hit;
	private String writeuser;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWriteuser() {
		return writeuser;
	}
	public void setWriteuser(String writeuser) {
		this.writeuser = writeuser;
	}

}
