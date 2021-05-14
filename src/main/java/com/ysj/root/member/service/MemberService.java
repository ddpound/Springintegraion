package com.ysj.root.member.service;

import com.ysj.root.member.dto.MemberDTO;

public interface MemberService {
	public int UserSave(MemberDTO dto);
	public int UserLogin(String id,String pw);
	
	
}
