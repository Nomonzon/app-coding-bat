insert into test
values (1, 'Boolean,Boolean,Boolean', 'false,false:true;true,false:false;false,true:true;true,true:true');
insert into test
values (2, 'Boolean,Boolean,Boolean', 'true,true:true;false,false:true;true,false:false;false,true:false');
insert into test
values (3, 'Integer,Integer,Integer', '1,2:3;3,2:5;2,2:8;-1,0:-1;3,3:12;0,0:0;0,1:1;3,4:7');
delete from test where id = 4;
insert into test values(4, 'Integer,Integer,Integer', '12,10:22;13,14:27;9,11:20;15,14:29');

select *
from test;

delete from test where id = 3;