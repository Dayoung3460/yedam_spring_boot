create sequence seq_board;

create table tbl_board (
  bno number(10,0),
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate,
  updatedate date default sysdate
);

alter table tbl_board add constraint pk_board primary key (bno);
commit;

insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '피건쓰', '잠온다', '김다영');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '학원', '학원 수업', '김다용');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '커피', '카페라떼', '김나영');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '컴', '컴퓨터', '김가영');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, '스마트폰', '스마트폰 충전중', '김보영');

select * from tbl_board order by bno;
select * from tbl_board where bno > 0;

-- 계획설명
-- order by bno, where bno > 0
-- 같은 결과임
-- bno pk, index 라 알아서 bno 오름차순으로 정렬해줌
