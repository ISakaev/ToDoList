--add Roles
INSERT INTO todolist.t_role(id, name) VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

--add ROLE_ADMIN to user with id = 2
--update t_user_roles set roles_id = 2 where user_id =2;