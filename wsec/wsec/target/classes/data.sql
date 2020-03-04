


insert into user (user_name, password,confirm_password) values('Sam','aaaa','aaaa');
insert into user (user_name, password,confirm_password) values('Gaby','bbbb','bbbb');
insert into user (user_name, password,confirm_password) values('Lily','cccc','cccc');
insert into user (user_name, password,confirm_password) values('Jim','dddd','dddd');
insert into user (user_name, password,confirm_password) values('Kim','eeee','eeee');
insert into user (user_name, password,confirm_password) values('karl','ffff','ffff');


insert into role(role_name) values('USER');
insert into role(role_name) values('ADMIN');
insert into role(role_name) values('MANAGER');
insert into role(role_name) values('CTO');

insert into role_users(role_id,user_id) values(1,1);
insert into role_users(role_id,user_id) values(2,2);
insert into role_users(role_id,user_id) values(1,3);
insert into role_users(role_id,user_id) values(3,4);
insert into role_users(role_id,user_id) values(4,5);
insert into role_users(role_id,user_id) values(1,6);


insert into message(message, user_id) values('Hi' ,1);
insert into message(message, user_id) values('Hello',1);
insert into message(message, user_id) values('Welcome',3);
insert into message(message, user_id) values('Happy New Year',3);
insert into message(message, user_id) values('Great Job',6);
insert into message(message, user_id) values('Good Morning',6);
insert into message(message, user_id) values('Good Night',1);


insert into page(page_name) values('Home');
insert into page(page_name) values('Admin');
insert into page(page_name) values('User');
insert into page(page_name) values('Message');
insert into page(page_name) values('Role');
insert into page(page_name) values('Page');
insert into page(page_name) values('About');



insert into page_role (page_id, role_id) values(1,1);
insert into page_role (page_id, role_id) values(1,2);
insert into page_role (page_id, role_id) values(1,3);
insert into page_role (page_id, role_id) values(1,3);
insert into page_role (page_id, role_id) values(2,2);
insert into page_role (page_id, role_id) values(2,3);
insert into page_role (page_id, role_id) values(2,4);
insert into page_role (page_id, role_id) values(3,2);
insert into page_role (page_id, role_id) values(3,3);
insert into page_role (page_id, role_id) values(3,4);
insert into page_role (page_id, role_id) values(4,1);
insert into page_role (page_id, role_id) values(4,2);
insert into page_role (page_id, role_id) values(4,3);
insert into page_role (page_id, role_id) values(4,4);
insert into page_role (page_id, role_id) values(5,2);
insert into page_role (page_id, role_id) values(5,3);
insert into page_role (page_id, role_id) values(5,4);
insert into page_role (page_id, role_id) values(6,2);
insert into page_role (page_id, role_id) values(6,3);
insert into page_role (page_id, role_id) values(6,4);
insert into page_role (page_id, role_id) values(7,1);
insert into page_role (page_id, role_id) values(7,2);
insert into page_role (page_id, role_id) values(7,3);
insert into page_role (page_id, role_id) values(7,4);





