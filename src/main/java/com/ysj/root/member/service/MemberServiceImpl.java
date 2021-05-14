package com.ysj.root.member.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.root.member.dao.MemberDAO;
import com.ysj.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO mapper;

	@Override
	public int UserSave(MemberDTO dto) {
		dto.setSessionId("nan");
		dto.setLimitTime(new Date(System.currentTimeMillis()));

		// 잘받아내는지 확인 완료(21.05.13)
		/*
		 * System.out.println(dto.getId()); System.out.println(dto.getPw());
		 * System.out.println(dto.getAddr()); System.out.println(dto.getSessionId());
		 * System.out.println(dto.getLimitTime());
		 */

		try {
			// 인설트 문이 성공적으로 실행됐을대는 널값을 준다네
			return mapper.UserSave(dto);

		} catch (Exception e) {
			// 아니면 에러문을 출력한다네
			e.printStackTrace();
			return 0; // 이미 아이디가있다는 의미로 넣자
		}

	}

	@Override
	public int UserLogin(String id, String pw) {
		MemberDTO dto = new MemberDTO();
		dto = mapper.LoginUser(id);
		
		// select 결과 값이 없을경우 null값을 출력한다(왜냐면 자료형이 MemberDTO 때문이다)
		try {
			if (dto.getId() != null) {
				if (dto.getPw().equals(pw)) {
					// session만들기 로직짜기
					
					return 1; // 로그인성공
				}else {
					return 0; // 비밀번호틀림
				}
			}
		} catch (Exception e) {
			System.out.println("아이디가 없어서 에러발생");
			return -1; // 아이디 없음
		}
		
		return -1; // 아이디 없음
	}

}
