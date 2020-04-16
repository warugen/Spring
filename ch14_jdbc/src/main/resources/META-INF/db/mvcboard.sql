DROP TABLE MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;
CREATE SEQUENCE MVC_BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
CREATE TABLE MVC_BOARD (
    bID         NUMBER(6)       PRIMARY KEY,
    bNAME       VARCHAR2(50)    NOT NULL,
    bTITLE      VARCHAR2(100)   NOT NULL,
    bCONTENT    VARCHAR2(1000) ,
    bDATE       DATE            DEFAULT SYSDATE NOT NULL,
    bHIT        NUMBER(6)       DEFAULT 0 NOT NULL,
    bGROUP      NUMBER(6)       NOT NULL,
    bSTEP       NUMBER(3)       NOT NULL,
    bINDENT     NUMBER(3)       NOT NULL,
    bIP         VARCHAR2(20)    NOT NULL
);

SELECT * FROM MVC_BOARD where bgroup=136;

-- 글목록 (startRow, endRow)
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP;
SELECT * FROM (SELECT ROWNUM RN, A.* 
    FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, BSTEP) A)
WHERE RN BETWEEN 1 AND 13;

-- 전체 글 갯수
SELECT COUNT(*) FROM MVC_BOARD;

-- 원글쓰기
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (MVC_BOARD_SEQ.nextval, '홍길동', '제목', '본문', MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.5');

INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (MVC_BOARD_SEQ.nextval, '홍길동2', '제목2', '본문2', MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.5');

-- 상세글 보기 (bID로 dto 가져오기)
SELECT * FROM MVC_BOARD WHERE bID=2;

-- 조회수 올리기(bID)
UPDATE MVC_BOARD SET bHIT = bHIT + 1
WHERE bID = 2;

-- 답변글 쓰기전 step A
UPDATE MVC_BOARD SET bSTEP = bSTEP +1 WHERE bGROUP=2 AND bSTEP >0;

-- 답변글쓰기
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (MVC_BOARD_SEQ.nextval, '답변2', '글2첫답변2', '본문2답변2', 2, 1, 1, '168.11.22.65');
    
-- 글 수정하기
UPDATE MVC_BOARD SET bNAME = '홍홍홍',
                    bTITLE = '제목수정',
                    bCONTENT = '본문수정',
                    bIP = '192.11.36.77'
WHERE bID=7;
-- 글 삭제하기
DELETE FROM MVC_BOARD WHERE bID = 1;

ROLLBACK;

COMMIT;