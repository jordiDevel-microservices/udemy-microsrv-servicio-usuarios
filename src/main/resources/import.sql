insert into usuarios (login, password, enabled, nombre, apellido, email) values ('jordi', '$2y$12$WrERet3JRa79FaNRCufEUeAMk.YQ14dWI.aDRF/R0tIJ48tfk71zK', true, 'jordi', 'sanchez', 'jsanchez@mail.me');
insert into usuarios (login, password, enabled, nombre, apellido, email) values ('admin', '$2y$12$gKTwLXIJZ.0pjzRT2vgIlud2yaH/prHcxCGv7d41kSbQ2mEyuC1.C', true, 'admin', 'admin', 'admin@mail.me');
insert into usuarios (login, password, enabled, nombre, apellido, email) values ('john', '$2y$12$a/6buK5jyJ.yDkrDAuHmI.U3hT.cWd7zA9GWJ7TV07haRh/Iv1bFa', true, 'john', 'doe', 'jdoe@mail.me');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

insert into usuarios_roles(usuario_id, role_id) values (1, 1);
insert into usuarios_roles(usuario_id, role_id) values (2, 1);
insert into usuarios_roles(usuario_id, role_id) values (2, 2);
insert into usuarios_roles(usuario_id, role_id) values (3, 1);
