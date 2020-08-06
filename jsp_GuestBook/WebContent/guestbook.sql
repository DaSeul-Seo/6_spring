
CREATE TABLE guestbook (
  no        NUMBER,
  name      VARCHAR2(80),
  password  VARCHAR2(20),
  content   VARCHAR2(2000),
  reg_date  DATE,
  PRIMARY KEY(no)
);

CREATE SEQUENCE seq_guestbook_no
INCREMENT BY 1 
START WITH 1 ;

select * from guestbook order by no asc;

insert into guestbook values(seq_guestbook_no.nextval, 'test', 'test', 'test', sysdate);

delete from guestbook where no=6;

drop table guestbook;
