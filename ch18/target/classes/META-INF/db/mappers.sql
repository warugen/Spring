
-- ★ Book.xml(신규순list, 도서보기(paging), 책갯수, 상세보기, 도서등록,  도서정보수정)
-- Book.xml id = mainList(신규도서순으로 list가져오기)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- Book.xml id = bookList (paging처리해서 도서이름 순으로 list가져오기)
SELECT * FROM BOOK ORDER BY BTITLE;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;
    
-- 검색 페이징 처리
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%' || 'S' || '%' ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;
    
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK WHERE BWRITER LIKE '%' || 's' || '%' ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;
    
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%' || '' || '%' OR BWRITER LIKE '%' || '' || '%' ORDER BY BTITLE) A)
    WHERE RN BETWEEN 1 AND 3;
    
-- Book.xml id = cntBook (등록된 책 갯수가져오기)
SELECT COUNT(*) FROM BOOK;

-- Book.xml id = getBook (책번호bnum으로 dto가져오기)
SELECT * FROM BOOK WHERE BNUM=1;

-- Book.xml id = registerBook (책 등록하기)
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, bimg1, bimg2, binfo) VALUES
    (BOOK_SQ.NEXTVAL, '오라클','오길동',SYSDATE, 'NOTHING.JPG', 'NOTHING.JPG','좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, bimg1, binfo) VALUES
    (BOOK_SQ.NEXTVAL, 'Java','윤길동',SYSDATE, 'NOTHING.JPG', '좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate,  bimg2, binfo) VALUES
    (BOOK_SQ.NEXTVAL, 'JSP','제이피',SYSDATE,  'NOTHING.JPG','좋은 spring책');
INSERT INTO BOOK (bnum, btitle, bwriter, brdate, binfo) VALUES
    (BOOK_SQ.NEXTVAL, 'PYTHON','팽길동',SYSDATE,  '좋은 spring책');
-- Book.xml id = modifyBook (책정보수정하기)
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg1='NOTHING.JPG',
    bimg2='NOTHING.JPG',
    binfo='좋은 책'
    WHERE BNUM=11;
-- ★ Member.xml(id중복체크, 가입, id로 dto가져오기, 정보수정)
-- Member.xml id=idConfirm (해당id가 몇개인지)
SELECT COUNT(*) FROM B_MEMBER WHERE MID='bbb';
-- Member.xml id = joinMember (회원가입)
INSERT INTO B_MEMBER VALUES
    ('bbb','1','홍길동','hybrid0506@gmail.com', '01234', '서울시 종로구');
-- Member.xml id = getMember (mid로 dto가져오기)
SELECT * FROM B_MEMBER WHERE MID='bbb';
-- Member.xml id = modifyMember (회원정보수정)
UPDATE B_MEMBER SET MPW='111',
                MNAME='유길동',
                MMAIL = 'hybrid0506@gmail.com',
                MADDR='서울시 용산구',
                MPOST = '01234'
        WHERE MID='bbb';

COMMIT;



































