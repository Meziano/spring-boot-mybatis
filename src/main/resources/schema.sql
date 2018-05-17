create table student
(
   id integer primary key auto_increment,
   firstname varchar(255) not null,
   lastname varchar(255) not null,   
   dob date not null,
   doi date, 
   semester int
);