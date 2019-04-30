insert into post (title, author, content, created_date, modified_date) values ('테스트1', 'test1@gmail.com', '테스트1의 본문', now(), now());
insert into post (title, author, content, created_date, modified_date) values ('테스트2', 'test2@gmail.com', '테스트2의 본문', now(), now());

insert into user (user_id, user_pw, enabled) values ('admin', '{bcrypt}$2a$10$KarcGJ4oMJCA9VNzUSycOOCTjxTYLfuHGOq9kO4n3WyQLbWwhA6Am', true);
insert into user_role (user_id, role) values ('admin', 'ROLE_USER');