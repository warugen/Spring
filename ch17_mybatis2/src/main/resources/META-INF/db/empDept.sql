-- Dept.xml (id="deptList")
SELECT * FROM DEPT;


-- Emp.xml (id="empList")
SELECT * FROM EMP ORDER BY EMPNO;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO) A)
WHERE RN BETWEEN 2 AND 6;

-- Emp.xml (id="total")
SELECT COUNT(*) FROM EMP;

-- Emp.xml (id="detail")
SELECT * FROM EMP WHERE EMPNO=7698;

-- Emp.xml (id="managerList")
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);

-- Emp.xml (id="empInsert")
INSERT INTO EMP VALUES (1000, 'HONG', 'IT', 7839, '2020-03-03', 9000, 900, 40);

-- Emp.xml (id="empUpdate")
UPDATE EMP SET ENAME = 'GILDONG',
                JOB = 'IT',
                MGR = 7566,
                HIREDATE = '2019-03-03',
                SAL = 8000,
                COMM = 90,
                DEPTNO = 40
        WHERE EMPNO = 1000;

-- Emp.xml (id="empDelete")
DELETE FROM EMP WHERE EMPNO = 1000;


-- EmpDept.xml (id="empDeptList")
SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO;

SELECT * FROM ( 
        SELECT ROWNUM RN, A.* FROM (
                SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO ) A )
        WHERE RN BETWEEN 1 AND 5;































