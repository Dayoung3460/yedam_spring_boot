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



create table tbl_reply (
  rno number(10,0),
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null,
  replyDate date default sysdate,
  updateDate date default sysdate
);

create sequence seq_board;
create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key (rno);

alter table tbl_reply  add constraint fk_reply_board
foreign key (bno)  references  tbl_board (bno);

insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014669, '댓글1', '홍길동1' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014669, '댓글추가', '홍길동2' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014669, '댓글추가', '홍길동3' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014670, '댓글4', '홍길동4' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014671, '댓글5', '홍길동5' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014672, '댓글6', '홍길동6' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014672, '댓글7', '홍길동7' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014673, '댓글8', '홍길동8' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014673, '댓글9', '홍길동9' );
insert into tbl_reply (rno, bno, reply, replyer) values ( seq_reply.nextval, 3014674, '댓글0', '홍길동10' );

select * from tbl_reply;
select * from tbl_board;

select count(*) 
        from tbl_reply
        where bno = 3014669;

UPDATE tbl_reply
        SET
            reply = 3014669,
            replyer = "test"
        WHERE rno = 1;

ALTER TABLE tbl_board ADD replycnt number(10) DEFAULT 0 NOT NULL;

commit;
