--esquema
-- DROP TABLE poll_answers
 CREATE TABLE poll_answers(
  ref INTEGER,
  pobl INTEGER NOT NULL,
  edat INTEGER NOT NULL,
  cand INTEGER NOT NULL,
  val INTEGER NOT NULL,
  resposta_1 VARCHAR2(10),
  resposta_2 VARCHAR2(10),
  resposta_3 VARCHAR2(10),
  resposta_4 VARCHAR2(10),
  resposta_5 VARCHAR2(10)
)PCTFREE 0 ENABLE ROW MOVEMENT;


---------- DELETE THE ORIGINAL TABLE AND CREATE A TABLE CONTAINING 
---------- NESTED TABLES (AND THE NEEDED COLLECTION TYPES)


-------- MODIFY THE INSERTS SCRIPT TO ADAPT IT TO YOUR OBJECT-RELATIONAL SCHEMA
----------------------------- INSERTS SCRIPT
DECLARE
  j INTEGER;
  maxTuples CONSTANT INTEGER := 20000;
  maxPobl CONSTANT INTEGER := 200;
  maxEdat CONSTANT INTEGER := 100;  
  maxCand CONSTANT INTEGER := 10;
  maxVal CONSTANT INTEGER := 10;  
BEGIN
DBMS_RANDOM.seed(0);
-- Insertions 
FOR j IN 1..(maxTuples) LOOP
    INSERT INTO poll_answers(ref,pobl,edat,cand,val,resposta_1,resposta_2,resposta_3,resposta_4,resposta_5)--,resposta_6,resposta_7,resposta_8,resposta_9,resposta_10) 
    VALUES (
    j, 
    dbms_random.value(1, maxPobl), 
    dbms_random.value(1,maxEdat), 
    dbms_random.value(1, maxCand),     
    dbms_random.value(1, maxVal),    
    LPAD(dbms_random.string('U',50),10,'-'),
    LPAD(dbms_random.string('U',50),10,'-'),
    LPAD(dbms_random.string('U',50),10,'-'),
    LPAD(dbms_random.string('U',50),10,'-'),
    LPAD(dbms_random.string('U',50),10,'-')
  );
END LOOP;
END;

COMMIT;

ALTER TABLE poll_answers SHRINK SPACE;

------ IF YOU WANT TO CREATE ANY OTHER INDEX DO IT HERE

ALTER TABLE poll_answers MINIMIZE RECORDS_PER_BLOCK; 
CREATE BITMAP INDEX bitmap1 ON poll_answers(pobl) PCTFREE 0;

CREATE BITMAP INDEX bitmap2 ON poll_answers(edat) PCTFREE 0;

CREATE BITMAP INDEX bitmap3 ON poll_answers(cand,val) PCTFREE 0;




SELECT pobl, MIN(edat), MAX(edat), COUNT(*) FROM poll_answers GROUP BY pobl; 

SELECT pobl, edat, cand, MAX(val), MIN(val), AVG(val) FROM poll_answers GROUP BY pobl, edat, cand; 

SELECT cand, AVG(val) FROM poll_answers GROUP BY cand; 


------ NOW, CREATE THE THREE NEEDED VIEWS ADAPTING THE THREE QUERIES IN THE STATEMENT
------ TO YOUR OBJECT-RELATIONAL SCHEMA

CREATE VIEW view1 AS 
SELECT xxxxx AS a, xxxxxx AS b, xxxxxx AS c, xxxxxx AS d
FROM xxxxxxxxxxxx
GROUP BY xxxxxxxxx;

CREATE VIEW view2 AS 
SELECT xxxxxxx AS a, xxxxxxx AS b, xxxxxxx AS c, xxxxxx AS d, xxxxxx AS e, xxxxxx AS f
FROM xxxxxxxxxx
GROUP BY xxxxxxx, xxxxxxx, xxxxxx;

CREATE VIEW view3 AS 
SELECT xxxxxxxx AS a, xxxxxxxx AS b
FROM xxxxxxxxxx
GROUP BY xxxxxxxx;


------------------------------------------- Update Statistics 
DECLARE
esquema VARCHAR2(100);
CURSOR c IS SELECT TABLE_NAME FROM USER_TABLES UNION SELECT TABLE_NAME FROM USER_OBJECT_TABLES;
BEGIN
SELECT '"'||sys_context('USERENV', 'CURRENT_SCHEMA')||'"' INTO esquema FROM dual;
FOR taula IN c LOOP
  DBMS_STATS.GATHER_TABLE_STATS( 
    ownname => esquema, 
    tabname => taula.table_name, 
    estimate_percent => NULL,
    method_opt =>'FOR ALL COLUMNS SIZE REPEAT',
    granularity => 'GLOBAL',
    cascade => TRUE
    );
  END LOOP;
END;



-- NO NEED TO MODIFY THE REST OF THIS CODE. IT RELIES ON THE VIEWS ABOVE CREATED
-- BE CAREFUL AND DO NOT REUSE THIS BIT OF CODE FROM PREVIOUS EXERCISES AS IT IS DIFFERENT
---------------------------- To check the real costs -------------------------

--DELETE FROM measure;
CREATE TABLE measure (id INTEGER, weight FLOAT, i FLOAT, f FLOAT);

DECLARE 
i0 INTEGER;
i1 INTEGER;
i2 INTEGER;
i3 INTEGER;
r INTEGER;
BEGIN
select value INTO i0 from v$statname c, v$sesstat a where a.statistic# = c.statistic# and sys_context('USERENV','SID') = a.sid and c.name in ('consistent gets');

SELECT MAX(LENGTH(a||b||c||d)) INTO r FROM (SELECT a, b, c, d
FROM view1
);
 
select value INTO i1 from v$statname c, v$sesstat a where a.statistic# = c.statistic# and sys_context('USERENV','SID') = a.sid and c.name in ('consistent gets');

SELECT MAX(LENGTH(a||b||c||d||e||f)) INTO r FROM (SELECT a, b, c, d, e, f
FROM view2
);

select value INTO i2 from v$statname c, v$sesstat a where a.statistic# = c.statistic# and sys_context('USERENV','SID') = a.sid and c.name in ('consistent gets');

SELECT MAX(LENGTH(a||b)) INTO r FROM (SELECT a,b
FROM view3
);

select value INTO i3 from v$statname c, v$sesstat a where a.statistic# = c.statistic# and sys_context('USERENV','SID') = a.sid and c.name in ('consistent gets');

INSERT INTO measure (id,weight,i,f) VALUES (1,0.2,i0,i1);
INSERT INTO measure (id,weight,i,f) VALUES (2,0.3,i1,i2);
INSERT INTO measure (id,weight,i,f) VALUES (3,0.5,i2,i3);
END;

--SELECT * FROM MEASURE;
SELECT SUM((f-i)*weight) FROM measure;
DROP TABLE measure PURGE;