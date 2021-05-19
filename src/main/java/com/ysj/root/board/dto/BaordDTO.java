package com.ysj.root.board.dto;

import java.sql.Date;

public class BaordDTO {
	private String boardId;
	private String title;
	private Date writedate;
	private int hit;
	private String writeuser;
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
