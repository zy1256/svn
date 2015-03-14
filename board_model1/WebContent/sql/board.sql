DROP TABLE board;
DROP SEQUENCE board_sequence;
CREATE TABLE board
 (
    boardno number not null primary key,
    title varchar2 (100) not null,
    writer varchar2 (20) not null,
    content varchar2 (2000) not null,
    regdate date default (SYSDATE),
    readcount number default (0),
    groupno number not null,
    step number not null,
    depth number default (0)
 );

CREATE SEQUENCE board_sequence;
--새글쓰기
INSERT INTO board
		(boardno, title, writer, content, groupno, step)
VALUES
		(board_sequence.nextval,'게시판타이틀1', '김경호1', 'content1',board_sequence.currval, 1);

commit;

/*
- ROWNUM은 쿼리 내에서 사용 가능한 (실제 컬럼이 아닌) 가상 컬럼(pseudocolumn)입니다.
- ROWNUM에는 숫자 1, 2, 3, 4, ... N의 값이 할당됩니다.
   여기서 N 은 ROWNUM과 함께 사용하는 로우의 수를 의미합니다.
- ROWNUM의 값은 로우에 영구적으로 할당되지 않습니다.
   테이블의 로우는 숫자와 연계되어 참조될 수 없습니다.
   따라서 테이블에서 "row 5"를 요청할 수 있는 방법은 없습니다.
   "row 5"라는 것은 존재하지 않기 때문입니다.
- ROWNUM 값은 쿼리의 조건절이 처리되고 난 이후,
   그리고 sort, aggregation이 수행되기 이전에 할당됩니다.
   또 ROWNUM 값은 할당된 이후에만 증가(increment) 됩니다.
   따라서 아래 쿼리는 로우를 반환하지 않습니다.
   ex>select * from emp where rownum > 1;

   ex>select ..., ROWNUM from emp where group by having order by ;
      이 쿼리는 다음과 같은 순서로 처리됩니다.
	1. FROM/WHERE 절이 먼저 처리됩니다.
	2. ROWNUM이 할당되고 FROM/WHERE 절에서 전달되는 각각의 출력 로우에 대해 증가(increment) 됩니다.
	3. SELECT가 적용됩니다.
	4. GROUP BY 조건이 적용됩니다.
	5. HAVING이 적용됩니다.
	6. ORDER BY 조건이 적용됩니다.
*/
-----------rownum--------------
select rownum,e.* from emp e;

select rownum,e.*  from emp e where rownum >= 5 and rownum <=10;

select rownum,e.*  from
    (
         select rownum rn ,emp.*  from emp
    ) e
where rn >= 5 and rn <=10;

select rownum,e.*  from
    (
         select rownum rn ,emp.*  from emp ORDER BY sal desc
    ) e
where rn >= 5 and rn <=10;

select *  from
    (
         select rownum rn ,e.*  from
            (
              select * from emp ORDER BY sal desc
            )e
    )
where rn >= 5 and rn <=10;



SELECT * FROM
		( SELECT rownum idx, s.*  FROM
				( SELECT * FROM board
					ORDER BY groupno DESC,step ASC
				) s
		 )
WHERE idx >= ? AND idx <= ? ;

-----------------------------------
--게시판리스트 페이지
SELECT * FROM
		( SELECT rownum idx, s.*  FROM
				( SELECT boardno, title, writer,regdate, readcount,groupno, step, depth FROM board
					ORDER BY groupno DESC,step ASC
				) s
		 )
WHERE idx >= ? AND idx <= ? ;

--1.게시판 리스트전체
SELECT 	boardno,
		title,
		writer,
		regdate,
		readcount,
		groupno,
		step,
		depth
FROM board
ORDER BY groupno DESC,step ASC;

--게시판 삭제
SELECT *
FROM board
WHERE groupno = ?  AND depth >= ? AND step >= ?
ORDER BY step, depth ASC;



SELECT boardno, title, writer,regdate, readcount,groupno, step, depth FROM board
					ORDER BY groupno DESC,step ASC


