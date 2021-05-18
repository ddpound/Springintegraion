-- 아래꺼가 내가 만든 integration 프로젝트의 데베
create table membership_in(
id varchar2(20) primary key,
pw varchar2(100),
addr varchar2(300),
session_id varchar2(100) default 'nan' not null,
limit_time date
);
-- 내가 만든 보드테이블
create table board_in(
board_id NUMBER(4,2) PRIMARY KEY,
title VARCHAR2(300),
contents CLOB,
writedate date default sysdate,
hit number(10) default 0,
writeuser varchar2(20),
CONSTRAINT fk_writeuser FOREIGN KEY(writeuser)
REFERENCES membership_in(id) ON DELETE CASCADE
);


-- 강사님이 올려주신 reply 테이블 (mvc_board라는 게시판 테이블을 참조하고있다)

create table reply(
id varchar(20),
title varchar(50),
content varchar(300),
write_group number(10),
write_date date default sysdate,
constraint fk_test foreign key(write_group) references mvc_board(write_no) on delete cascade
);

-- 이건 페이징 처리할때 필요한 sql 문
select B.* from(select rownum rn, A.* from
(select * from mvc_board order by write_no desc)A)B where rn between #{s} and #{e}
