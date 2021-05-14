-- 아래꺼가 내가 만든 integration 프로젝트의 데베
create table membership_in(
id varchar2(20) primary key,
pw varchar2(100),
addr varchar2(300),
session_id varchar2(100) default 'nan' not null,
limit_time date
)