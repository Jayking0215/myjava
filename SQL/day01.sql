SELECT * FROM tab;
--단문주석
/*
본문주석
c:/myjava/SQL/day01.sql
F5=스크립트 전체 출력
select * from dept; + (ctrl+enter)/현재 스크립트 출력
*/
--인사 관리 시스템
SELECT * FROM emp;--부모테이블: deptno: PK(unique + not null)
SELECT * FROM dept;--자식테이블: deptno : FK
--emp은 dept에 소속되어 있다

SELECT ename,job,sal FROM emp;
SELECT empno, ename, sal, sal+300 AS sal_up FROM emp;--산술식도 적용 가능(AS는 별칭 부여)_alias

--emp에서 사번, 사원명, 급여, 보너스(comm),연봉(급여*12)+보너스 AS YEAR_SAL
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+COMM AS YEAR_SAL FROM EMP;
--null: 연산하면 모든 값을 null로 만듬
--NVL(컬럼명, 값)함수...컬럼이 NULL일경우 값으로 대체
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+NVL(COMM,0) AS YEAR_SAL FROM EMP;
--NVL2(EXPR, EXPR1, EXPR2) ...EXPR값이 NULL이 아닐경우 EXPR1값을 반환하고 NULL이면 EXPR2를 반환
SELECT EMPNO, ENAME, MGR, NVL2(MGR, 1, 0) "관리자 존재 여부" FROM EMP;


--쇼핑몰 시스템
select * from member;
select * from category;
select * from products;
select * from supply_comp;


--학생 테이블 생성
create table student(
    num number(4) Primary key, --primary: unique한 값+not null
    --number는 정수
    name varchar2(30) not null, 
    --varchar2는 문장, 단어
    --not null은 필수입력    
    addr varchar2(100) not null,
    tel varchar2(15) not null,
    indate date default sysdate, --시스템의 현재 날짜를 default로 설정
    cname varchar2(50),
    croom number(3)
);

select * from student;
-- 학생정보 등록
/*
inser into 테이블명(컬럼명1, 컬럼명2,...)
values(값1, 값2...);
*/

insert into student(num, name, addr, tel, cname, croom)
values(1, '홍길동', '서울특별시', '010-1234-5678', '백앤드 개발자반', 201);
commit;--db에 영구저장
select * from student;

insert into student(num, addr, name, tel, cname, croom)
values(2, '인천광역시', '홍길서', '010-4321-9876', '백앤드 개발자반', 201);
--아직 DB에 들어가기 전 메모리에 올라가있는 상태
rollback; --취소...메모리에서 삭제
commit;

insert into student(num, name, addr, tel)
values(3, '홍길남', '경기도', '010-1234-1234');

select * from student;
commit;

insert into student--컬럼명 생략하면 모든 컬럼 불러온것으로 간주
values(4, '홍길북', '대전광역시', '010-5432-2345', '2023/03/21', '빅데이터반', 202);
select * from student;
commit;--transaction control language = TCL

--빅데이터반 2명 추가//AI개발자반 1명 203호 등록
insert into student
values(5,'빅데1','울산광역시','010-5432-3574','2023/01/14','빅데이터반',202);
insert into student
values(6,'빅데2','부산광역시','010-5232-3644','2023/01/16','빅데이터반',202);
commit;
select * from student;
insert into student
values(7, '아이1', '경기경기', '010-1234-1423', '2022/12/14', 'AI개발자반', 203);
commit;
--데이터 수정
/*
update 테이블명 set 컬럼명1=수정값1, 컬럼명2=수정값2,.....
where 조건절
*/
select * from student;
update student set cname='백앤드 개발자반', croom=201 where num=3;

--이름이 홍길동인 학생의 연락처를 011-1234-5678로 수정
update student set tel='011-1234-5678'
where num=1;--where '홍길동' and croom=201도 가능
select * from student;
rollback;--커밋하면 의미없음....
commit;

--데이터 삭제
--delete from 테이블명 where 조건절;
select * from student;
delete from student where num=5;
select * from student;
--rollback;
--select * from student;
commit;
--commit은 확실할때만 할것!!!
insert into student
values(8,'유재석','제주특별시','010-2929-3939',sysdate,'백앤드','301');
commit;

select * from student
where croom=201;--...데이터의 결함 발생(8번 학생 오타)=DB설계 오류
-->중복되는 데이터가 발생하는 table을 따로 생성(primary key값->foreign key값)

--테이블 삭제:DDL(Data Delete Language)..커밋 불필요
--drop table 테이블명;
DROP TABLE STUDENT;

--테이블 생성(부모테이블, MASTER TABLE)
CREATE TABLE SCLASS(
    SNUM NUMBER(4) PRIMARY KEY,--학급번호-PK
    SNAME VARCHAR2(50) NOT NULL,--학급명
    SROOM NUMBER(3)--교실-NULL허용
);
DESC SCLASS;
CREATE TABLE STUDENT(
    NUM NUMBER(4) PRIMARY KEY,--학번
    NAME VARCHAR2(30) NOT NULL,
    ADDR VARCHAR2(100) NOT NULL,
    TEL VARCHAR2(15) NOT NULL,
    INDATE DATE DEFAULT SYSDATE,
    SNUM_FK NUMBER(4) REFERENCES SCLASS(SNUM)
);
DESC STUDENT;

--학급 데이터를 삽입
--10 백앤드개발자반 201
--20 빅데이터반 202
--30 AI개발자반 203

INSERT INTO SCLASS
VALUES(10, '백앤드개발자반', 201);
SELECT * FROM SCLASS;

INSERT INTO SCLASS
VALUES(20, '빅데이터반', 202);

INSERT INTO SCLASS
VALUES(30, 'AI개발자반', 203);
SELECT * FROM SCLASS;
COMMIT;

--학생 데이터 삽입
--10번 학급에 3명 등록
--20번 학급에 3명 등록
--30번 학급에 3명 등록

INSERT INTO STUDENT(NUM, NAME, ADDR, TEL, SNUM_FK)
VALUES(1, 'KHAL','SEOUL','010-1111-1111',SYSDATE, 10);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(2, 'SHANE','TOKYO','010-2222-2222',SYSDATE, 10);

INSERT INTO STUDENT
VALUES(3, 'MULE','SANHAI','010-3333-3333',SYSDATE, 10);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(4, 'LUAS','NEWYORK','010-4444-4444',SYSDATE, 20);

INSERT INTO STUDENT
VALUES(5, 'HANLY','SIDNEY','010-5555-5555',SYSDATE, 20);

INSERT INTO STUDENT
VALUES(6, 'HAUL','MANILA','010-6666-6666',SYSDATE, 20);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(7, 'THALA','MARS','010-7777-7777',SYSDATE, 30);

INSERT INTO STUDENT
VALUES(8, 'MARRY','JUPITER','010-8888-8888',SYSDATE, 30);

INSERT INTO STUDENT
VALUES(9, 'MONGO','BATICAN','010-9999-9999',SYSDATE, 30);
SELECT * FROM STUDENT;
COMMIT;

--삽입 이상 방지
INSERT INTO STUDENT
VALUES(10, 'MILLA','ISTANBUL','010-1222-2111','23-03-21',40);--오류

--수정 이상 방지
--1번 학생의 학급 변경하되 30번학급으로 변경
UPDATE STUDENT SET SNUM_FK=30 WHERE NUM=1;
SELECT * FROM STUDENT;
--2번 학생의 학급은 40번 학급으로 변경
UPDATE STUDENT SET SNUM_FK=40 WHERE NUM=2;--오류
SELECT * FROM STUDENT;

--삭제 이상 방지
SELECT COUNT(*) FROM STUDENT WHERE SNUM_FK=10;
DELETE FROM SCLASS WHERE SNUM=10;--오류
--FOREIGN KEY로 참조하는 DATA가 자식TABLE에 있다면 삭제할 수 없다.

SELECT * FROM STUDENT;--학급명을 알 수 없다.
--JOIN문-->정규화의 가독성 저하를 해결
SELECT SNUM, SNAME ,NAME, TEL, INDATE, SNUM_FK
FROM SCLASS JOIN STUDENT--대상
ON SCLASS.SNUM = STUDENT.SNUM_FK--조건
ORDER BY SNUM ASC;--오름차순 정렬
