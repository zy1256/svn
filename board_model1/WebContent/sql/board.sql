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
--���۾���
INSERT INTO board
		(boardno, title, writer, content, groupno, step)
VALUES
		(board_sequence.nextval,'�Խ���Ÿ��Ʋ1', '���ȣ1', 'content1',board_sequence.currval, 1);

commit;

/*
- ROWNUM�� ���� ������ ��� ������ (���� �÷��� �ƴ�) ���� �÷�(pseudocolumn)�Դϴ�.
- ROWNUM���� ���� 1, 2, 3, 4, ... N�� ���� �Ҵ�˴ϴ�.
   ���⼭ N �� ROWNUM�� �Բ� ����ϴ� �ο��� ���� �ǹ��մϴ�.
- ROWNUM�� ���� �ο쿡 ���������� �Ҵ���� �ʽ��ϴ�.
   ���̺��� �ο�� ���ڿ� ����Ǿ� ������ �� �����ϴ�.
   ���� ���̺��� "row 5"�� ��û�� �� �ִ� ����� �����ϴ�.
   "row 5"��� ���� �������� �ʱ� �����Դϴ�.
- ROWNUM ���� ������ �������� ó���ǰ� �� ����,
   �׸��� sort, aggregation�� ����Ǳ� ������ �Ҵ�˴ϴ�.
   �� ROWNUM ���� �Ҵ�� ���Ŀ��� ����(increment) �˴ϴ�.
   ���� �Ʒ� ������ �ο츦 ��ȯ���� �ʽ��ϴ�.
   ex>select * from emp where rownum > 1;

   ex>select ..., ROWNUM from emp where group by having order by ;
      �� ������ ������ ���� ������ ó���˴ϴ�.
	1. FROM/WHERE ���� ���� ó���˴ϴ�.
	2. ROWNUM�� �Ҵ�ǰ� FROM/WHERE ������ ���޵Ǵ� ������ ��� �ο쿡 ���� ����(increment) �˴ϴ�.
	3. SELECT�� ����˴ϴ�.
	4. GROUP BY ������ ����˴ϴ�.
	5. HAVING�� ����˴ϴ�.
	6. ORDER BY ������ ����˴ϴ�.
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
--�Խ��Ǹ���Ʈ ������
SELECT * FROM
		( SELECT rownum idx, s.*  FROM
				( SELECT boardno, title, writer,regdate, readcount,groupno, step, depth FROM board
					ORDER BY groupno DESC,step ASC
				) s
		 )
WHERE idx >= ? AND idx <= ? ;

--1.�Խ��� ����Ʈ��ü
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

--�Խ��� ����
SELECT *
FROM board
WHERE groupno = ?  AND depth >= ? AND step >= ?
ORDER BY step, depth ASC;



SELECT boardno, title, writer,regdate, readcount,groupno, step, depth FROM board
					ORDER BY groupno DESC,step ASC


