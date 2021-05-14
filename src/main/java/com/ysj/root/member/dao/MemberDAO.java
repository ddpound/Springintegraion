package com.ysj.root.member.dao;

import com.ysj.root.member.dto.MemberDTO;

public interface MemberDAO {
	public int UserSave(MemberDTO dto);
	public MemberDTO LoginUser(String id);
	
}
