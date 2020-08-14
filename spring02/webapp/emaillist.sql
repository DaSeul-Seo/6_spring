DROP TABLE emaillist;
drop sequence seq_emaillist_no;


CREATE TABLE emaillist (
  no	NUMBER,
  last_name	VARCHAR2(5),
  first_name	VARCHAR2(10),
  email VARCHAR(100) not null,
  PRIMARY KEY(no)	
);


CREATE SEQUENCE seq_emaillist_no
INCREMENT BY 1 
START WITH 1 ;


insert into emaillist 
values (seq_emaillist_no.nextval, 
        '정', 
        '종욱', 
        'jongukjeong@gmail.com');

insert into emaillist 
values (seq_emaillist_no.nextval, 
        '정', 
        '우성', 
        'jus@gmail.com');



select no, last_name, first_name, email
from emaillist
order by no desc;

select * from EMAILLIST order by no asc;