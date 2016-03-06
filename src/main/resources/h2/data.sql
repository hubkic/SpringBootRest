drop table Name;

CREATE TABLE IF NOT EXISTS Name(
	ID         BIGINT PRIMARY KEY auto_increment,
  	FIRSTNAME       VARCHAR(30),
  	LASTNAME       VARCHAR(30)
);

delete from Name;

insert into Name values (0,'John','Big');
insert into Name values (1,'Stephen','Mouse');
insert into Name values (2,'Connor','Lamp');
insert into Name values (3,'Olivia','Head');